/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.model.Theater;
import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.service.ScreenService;
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.service.TheaterService;
import com.ideas2it.ideas2movie.repository.ScreenRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.exception.NoContentException;

/**
 * <h2>
 *     Screen Service Impl
 * </h2>
 * <p>
 *     Implements the Screen Service and
 *     Holds the Business Logics
 *     to Create, Update, Delete, Get the Details of the Screen
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@Service
public class ScreenServiceImpl implements ScreenService {
    private final ScreenRepository screenRepository;
    private final SeatService seatService;
    private final TheaterService theaterService;
    private final ReservationService reservationService;
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     ScreenServiceImpl Constructor
     * </h1>
     * <p>
     *     Used to  inject the ScreenRepository, SeatService,  TheaterService
     *     And ReservationService dependency to initialize the variables
     *     screenRepository, seatService, theaterService and reservationService
     * </p>
     * @param screenRepository - Instance of ScreenRepository
     * @param seatService - Instance of SeatService
     * @param theaterService - Instance of TheaterService
     * @param reservationService - Instance of ReservationService
     */
    public ScreenServiceImpl(ScreenRepository screenRepository, SeatService seatService,
                             TheaterService theaterService, ReservationService reservationService){
        this.screenRepository = screenRepository;
        this.seatService = seatService;
        this.theaterService = theaterService;
        this.reservationService = reservationService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScreenResponseDTO createScreen(ScreenDTO screenDTO) throws AlreadyExistException, BadRequestException {
        Screen screen = mapper.map(screenDTO, Screen.class);
        Screen createdScreen;
        Theater theater;

        try {
            theater = theaterService.getTheaterForScreenById(screenDTO.getTheaterId());
        }catch (NotFoundException notFoundException){
            throw new BadRequestException(Message.THEATER_NOT_FOUND);
        }
        screen.setTheater(theater);

        if (screenRepository.existsScreenByNameAndTheaterId(screenDTO.getName(), screenDTO.getTheaterId())){
            throw new AlreadyExistException(Message.SCREEN_ALREADY_EXISTS);
        }
        createdScreen = screenRepository.save(screen);

        if (screenRepository.findById(createdScreen.getId()).isPresent()) {
            seatService.createSeat(createdScreen);
        }
        return mapper.map(createdScreen, ScreenResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScreenResponseDTO updateScreen(Long id, ScreenDTO screenDTO) throws AlreadyExistException, NotFoundException,
            BadRequestException {
        Optional<Screen> existingScreen;
        Theater theater;
        Screen screen = mapper.map(screenDTO, Screen.class);
        screen.setId(id);
        screen.setActive(true);
        Screen updatedScreen;

        try {
            theater = theaterService.getTheaterForScreenById(screenDTO.getTheaterId());
        }catch (NotFoundException notFoundException){
            throw new BadRequestException(Message.THEATER_NOT_FOUND);

        }
        screen.setTheater(theater);
        existingScreen = screenRepository.findByIdAndTheaterId(id, theater.getId());

        if (existingScreen.isPresent()){
            if (isScreenAlreadyExistsInTheTheater(screen)){
                throw new AlreadyExistException(Message.SCREEN_ALREADY_EXISTS);
            } else {
                updatedScreen = screenRepository.save(screen);
            }
        } else{
            throw new NotFoundException(Message.SCREEN_NOT_FOUND);
        }

        return mapper.map(updatedScreen, ScreenResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeScreen(Long id) throws NotFoundException {
        Optional<Screen> existingScreen = screenRepository.findById(id);
        List<Show> shows = new ArrayList<>();
        Screen screen;
        boolean isRemoved;

        if (existingScreen.isPresent()){
            screen = existingScreen.get();
        } else {
            throw new NotFoundException(Message.SCREEN_NOT_FOUND);
        }
        screen.setActive(false);
        screen.getShows().forEach(show -> {show.setActive(false); shows.add(show);});
        screen.setShows(shows);
        isRemoved = screenRepository.save(screen).isActive();
        reservationService.cancelAllReservationsForShow(screen);
        return isRemoved;
    }

    /**
     * {@inheritDoc}
     */
    public Screen getScreenById(Long id) throws NotFoundException {
        Optional<Screen> existingScreen = screenRepository.findById(id);

        if (existingScreen.isEmpty()){
            throw new NotFoundException(Message.SCREEN_NOT_FOUND);
        }
        return  existingScreen.get();
    }

    /**
     * {@inheritDoc}
     */
    public List<ScreenResponseDTO> getScreensByTheaterId(Long id) throws NoContentException {
        List<Screen> existingScreens = screenRepository.findAllByTheaterId(id);
        List<ScreenResponseDTO> screens = new ArrayList<>();

        if (existingScreens.isEmpty()){
            throw new NoContentException(Message.SCREEN_NOT_FOUND);
        }
        existingScreens.forEach(screen -> screens.add(mapper.map(screen, ScreenResponseDTO.class)));
        return screens;
    }

    /**
     * <h1>
     *     isScreenAlreadyExistsInTheTheater
     * </h1>
     * <p>
     *     Checks the Screen is Already exist
     *     in the theater with the help of
     *     screen name and the theater id
     * </p>
     *
     * @param screen - Holds the details of the screen
     * @return isExists - Holds the result based on the screen exists
     */
    private boolean isScreenAlreadyExistsInTheTheater(Screen screen) {
        boolean isExists = false;
        Optional<Screen> existingScreen = screenRepository.findByNameAndTheaterId(screen.getName(),
                screen.getTheater().getId());

        if (existingScreen.isPresent()){
            if (!Objects.equals(existingScreen.get().getId(), screen.getId())){
                isExists = true;
            }
        }
        return isExists;
    }
}
