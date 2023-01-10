/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Theater;
import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.service.ScreenService;
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.service.TheaterService;
import com.ideas2it.ideas2movie.repository.ScreenRepository;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     Screen Service Impl
 * </h1>
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
    private final ModelMapper mapper = new ModelMapper();

    public ScreenServiceImpl(ScreenRepository screenRepository, SeatService seatService,
                             TheaterService theaterService){
        this.screenRepository = screenRepository;
        this.seatService = seatService;
        this.theaterService = theaterService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScreenResponseDTO createScreen(ScreenDTO screenDTO) throws NotFoundException, AlreadyExistException {
        Screen screen = mapper.map(screenDTO, Screen.class);
        Screen createdScreen;
        Theater theater = theaterService.getTheaterForScreenById(screenDTO.getTheaterId());
        screen.setTheater(theater);

        if (screenRepository.existsScreenByNameAndTheaterId(screenDTO.getName(), screenDTO.getTheaterId())){
            throw new AlreadyExistException("Screen with given name is already exist in the theater");
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
    public ScreenResponseDTO updateScreen(Long id, ScreenDTO screenDTO) throws AlreadyExistException, NotFoundException {
        Theater theater = theaterService.getTheaterForScreenById(screenDTO.getTheaterId());
        Screen screen = mapper.map(screenDTO, Screen.class);
        Screen updatedScreen;
        Optional<Screen> existingScreen;

        screen.setTheater(theater);
        existingScreen = screenRepository.findByIdAndTheaterId(id, theater.getId());

        if (existingScreen.isPresent()){
            if (isScreenAlreadyExistsInTheTheater(screen)){
                throw new AlreadyExistException("There is a Screen with given name in the given theater");
            } else {
                updatedScreen = screenRepository.save(screen);
            }
        } else{
            throw new NotFoundException("There is No Screen with this id in the theater");
        }

        return mapper.map(updatedScreen, ScreenResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteScreen(Long id) throws NotFoundException {
        Optional<Screen> existingScreen = screenRepository.findById(id);
        Screen screen;
        if (existingScreen.isPresent()){
            screen = existingScreen.get();
        } else {
            throw new NotFoundException("There is no screen with this screen id ");
        }
        screen.setActive(false);
        screenRepository.save(screen);
        return "Deleted SuccessFully";
    }

    /**
     * {@inheritDoc}
     */
    public Screen getScreenById(Long id) throws NotFoundException {
        Optional<Screen> existingScreen = screenRepository.findById(id);

        if (existingScreen.isEmpty()){
            throw new NotFoundException("There is No Screen with given id");
        }
        return  existingScreen.get();
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
