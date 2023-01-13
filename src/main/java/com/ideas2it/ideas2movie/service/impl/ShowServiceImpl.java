/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.dto.responsedto.SeatResponseDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ShowResponseDTO;
import com.ideas2it.ideas2movie.service.MovieService;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.service.ScreenService;
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.service.ShowService;
import com.ideas2it.ideas2movie.repository.ShowRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotAcceptableException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     Show Service Impl
 * </h1>
 * <p>
 *     Implements the Show Service and
 *     Holds the Business Logics
 *     to Create, Update, Cancel, Get the Details of the Show
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final MovieService movieService;
    private final ScreenService screenService;
    private final SeatService seatService;
    private final ReservationService reservationService;

    public ShowServiceImpl(ShowRepository showRepository, ScreenService screenService,
                           MovieService movieService, SeatService seatService,
                           ReservationService reservationService){
        this.showRepository = showRepository;
        this.movieService = movieService;
        this.screenService = screenService;
        this.seatService = seatService;
        this.reservationService = reservationService;
    }

    /**
     * {@inheritDoc}
     */
    public ShowResponseDTO createShow(ShowDTO showDTO) throws AlreadyExistException, NotAcceptableException, BadRequestException {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Show show = mapper.map(showDTO, Show.class);

        try {
            show.setMovie(movieService.getMovieByIdForShows(showDTO.getMovieId()));
            show.setScreen(screenService.getScreenById(showDTO.getScreenId()));
        } catch (NotFoundException notFoundException){
            throw new BadRequestException(notFoundException.getMessage());
        }

        if (show.getStartTime().isAfter(show.getEndTime())) {
            throw new NotAcceptableException(Message.INVALID_SHOW_TIME);
        }

        if (isAnyShowExistInGivenTimeAtGivenScreen(show)){
            throw new AlreadyExistException(Message.SHOW_ALREADY_EXISTS);
        }
        return mapper.map(showRepository.save(show), ShowResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    public String cancelShow(Long id) throws NotFoundException {
        Optional<Show> existingShow = showRepository.findById(id);
        Show show;

        if (existingShow.isEmpty()){
            throw new NotFoundException(Message.SHOW_NOT_FOUND);
        }
        show = existingShow.get();
        show.setActive(false);
        showRepository.save(show);
        return Message.DELETED_SUCCESSFULLY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ShowResponseDTO> getAllShowsByMovieName(String movieName) throws NoContentException {
        List<Show> shows = showRepository.findByMovieName(movieName);
        List<ShowResponseDTO> listOfShowsForParticularMovie = new ArrayList<>();
        ShowResponseDTO showResponseDTO;

        if (shows.isEmpty()) {
            throw new NoContentException(Message.NO_SHOWS_AVAILABLE);
        } else {

            for(Show show: shows){
                showResponseDTO = mapper.map(show, ShowResponseDTO.class);
                showResponseDTO.setAvailableSeats(getAvailableSeats(show));
                listOfShowsForParticularMovie.add(showResponseDTO);
            }
        }
        return listOfShowsForParticularMovie;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShowResponseDTO getShowById(Long id) throws NotFoundException {
        Optional<Show> existingShow = showRepository.findById(id);
        ShowResponseDTO showResponseDTO;

        if (existingShow.isPresent()){
            showResponseDTO = mapper.map(existingShow.get(), ShowResponseDTO.class);
            showResponseDTO.setAvailableSeats(getAvailableSeats(existingShow.get()));
        } else {
            throw new NotFoundException(Message.SHOW_NOT_FOUND);
        }

        return showResponseDTO;
    }

    /**
     *{@inheritDoc}
     */
    public List<Show> getAllShowsForScreen(Long id) throws NoContentException {
        List<Show> shows = showRepository.findAllByScreenId(id);

        if (shows.isEmpty()) {
            throw new NoContentException(Message.NO_SHOWS_AVAILABLE);
        }
        return shows;
    }

    /**
     * <h1>
     *     getAvailableSeats
     * </h1>
     * <p>
     *     Gets the Available seats for the
     *     particular show for the particular
     *     screen
     * </p>
     * @param show - Holds the details of the show
     * @return listOfSeats - Holds the list of available seats for the particular show
     */
    private List<SeatResponseDTO> getAvailableSeats(Show show) {
        List<Seat> seats = seatService.getSeatsByScreenId(show.getScreen().getId());
        List<Seat> bookedSeats = reservationService.getReservedSeats(show.getId());
        List<SeatResponseDTO> listOfAvailableSeats = new ArrayList<>();

        if (!bookedSeats.isEmpty()){
            seats.removeAll(bookedSeats);
        }

        for (Seat seat : seats){
            listOfAvailableSeats.add(mapper.map(seat, SeatResponseDTO.class));
        }
        return listOfAvailableSeats;
    }

    /**
     * <h1>
     *     isAnyShowExistInGivenTimeAtGivenScreen
     * </h1>
     * <p>
     *     Checks Any show is exists at given time at the given screen
     *     for particular date . If the start time of the given show is equal to
     *     or after the start time of an existing show, and before
     *     or equal to the end time of an existing show
     * </p>
     * @param show - Holds the Show details
     * @return boolean - true if Show is Exists already otherwise false
     */
    private boolean isAnyShowExistInGivenTimeAtGivenScreen(Show show){
        List<Show> shows = showRepository.findAllByScreeningDateAndScreenId(show.getScreeningDate(),
                                                                            show.getScreen().getId());
        boolean isExists = false;

        for (Show existingShow: shows){

            if (((show.getStartTime().equals(existingShow.getStartTime())
                    || show.getStartTime().isAfter(existingShow.getStartTime()))
                    &&(show.getStartTime().equals(existingShow.getEndTime())
                    || show.getStartTime().isBefore(existingShow.getEndTime())))
                    ||
                    (show.getStartTime().isBefore(existingShow.getStartTime())
                    && show.getEndTime().isAfter(existingShow.getStartTime()))) {
                isExists = true;
                break;
            }
        }
        return isExists;
    }
}
