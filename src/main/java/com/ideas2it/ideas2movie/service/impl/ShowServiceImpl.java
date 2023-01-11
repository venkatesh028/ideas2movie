/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.logging.log4j2.SpringBootConfigurationFactory;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Screen;
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
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h1>
 *     Show Service Impl
 * </h1>
 * <p>
 *     Implements the Show Service and
 *     Holds the Business Logics
 *     to Create, Update, Delete, Get the Details of the Show
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
    private final CustomLogger logger = new CustomLogger(ShowServiceImpl.class);
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
    public ShowResponseDTO createShow(ShowDTO showDTO) throws NotFoundException, AlreadyExistException {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Show show = mapper.map(showDTO, Show.class);
        show.setMovie(movieService.getMovieByIdForShows(showDTO.getMovieId()));
        show.setScreen(screenService.getScreenById(showDTO.getScreenId()));

        if (showRepository.existsByScreeningDateAndStartTimeAndScreen(show.getScreeningDate(),
                show.getStartTime(), show.getScreen())){
            throw new AlreadyExistException("There is show in this screen exactly at given time and date");
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
            throw new NotFoundException("There is No show in given id");
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
        ShowResponseDTO showResponseDTO = null;

        if (shows.isEmpty()) {
            throw new NoContentException("There is No Shows For Given Movie");
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

    public boolean cancelShowsForRemovedScreen(Screen screen){
        List<Show> shows = showRepository.findByScreenId(screen.getId());
        int canceledShowsCount = 0;

        for (Show show: shows){
            if(reservationService.cancelAllReservationForShow(show)){
                show.setActive(false);
                showRepository.save(show);
                canceledShowsCount++;
            }
        }

        return (canceledShowsCount == shows.size());
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
        seats.removeAll(bookedSeats);

        for (Seat seat : seats){
            listOfAvailableSeats.add(mapper.map(seat, SeatResponseDTO.class));
        }
        return listOfAvailableSeats;
    }
}
