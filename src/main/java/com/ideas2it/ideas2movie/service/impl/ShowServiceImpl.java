/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ShowResponseDTO;
import com.ideas2it.ideas2movie.repository.ShowRepository;
import com.ideas2it.ideas2movie.service.MovieService;
import com.ideas2it.ideas2movie.service.ScreenService;
import com.ideas2it.ideas2movie.service.ShowService;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotAcceptableException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.util.constant.Message;

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
    private final MovieService movieService;
    private final ScreenService screenService;

    public ShowServiceImpl(ShowRepository showRepository, ScreenService screenService,
                           MovieService movieService){
        this.showRepository = showRepository;
        this.movieService = movieService;
        this.screenService = screenService;
    }

    /**
     * {@inheritDoc}
     */
    public ShowResponseDTO createShow(ShowDTO showDTO) throws NotFoundException, AlreadyExistException,
                                                              NotAcceptableException {
        Show show = mapper.map(showDTO, Show.class);
        show.setMovie(movieService.getMovieByIdForShows(showDTO.getMovieId()));
        show.setScreen(screenService.getScreenById(showDTO.getScreenId()));
        int totalNumberOfSeatsInScreen = show.getScreen().getTotalNumberOfColumns() *
                                                show.getScreen().getTotalNumberOfRows();

        if (show.getAvailableSeats() > totalNumberOfSeatsInScreen){
            throw new NotAcceptableException("Seats Allocated For the Show is Higher " +
                                             "than the total number of Seats in Screen");
        }

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
    public List<Show> getAllShowsByMovieName(String movieName) throws NoContentException {
        List<Show> shows = showRepository.findByMovieName(movieName);

        if (shows.isEmpty()) {
            throw new NoContentException("There is No Shows For Given Movie");
        }
        return shows;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Show updateAvailableSeatsOfShow(int bookedSeats, Long showId) {
        Optional<Show> existingShow = showRepository.findById(showId);
        Show updatedShow = null;

        if (existingShow.isPresent()){
            Show show = existingShow.get();
            show.setAvailableSeats(show.getAvailableSeats() - bookedSeats);
            updatedShow = showRepository.save(show);
        }
        return updatedShow;
    }
}
