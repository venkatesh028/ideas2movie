/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.repository.ScreenRepository;
import com.ideas2it.ideas2movie.service.ScreenService;
import com.ideas2it.ideas2movie.service.TheaterService;

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
    private final TheaterService theaterService;
    private final ModelMapper mapper = new ModelMapper();

    public ScreenServiceImpl(ScreenRepository screenRepository, TheaterService theaterService){
        this.screenRepository = screenRepository;
        this.theaterService = theaterService;
    }

    @Override
    public ScreenResponseDTO createScreen(ScreenDTO screenDTO) throws NotFoundException, AlreadyExistException {
        Screen screen = mapper.map(screenDTO, Screen.class);

        if (screenRepository.existsScreenByNameAndTheaterId(screenDTO.getName(), screenDTO.getTheaterId())){
            throw new AlreadyExistException("There a Screen with given name");
        }
        screen.setTheater(theaterService.getTheaterForScreenById(screenDTO.getTheaterId()));
        return mapper.map(screenRepository.save(screen), ScreenResponseDTO.class);
    }

    @Override
    public ScreenResponseDTO updateScreen(Long id, ScreenDTO screenDTO) throws AlreadyExistException, NotFoundException {
        Screen screen = mapper.map(screenDTO, Screen.class);
        screen.setId(id);
        screen.setTheater(theaterService.getTheaterForScreenById(screenDTO.getTheaterId()));

        if (screenRepository.existsScreenByNameAndTheaterId(screen.getName(),
                screen.getTheater().getId())) {
            throw new AlreadyExistException("This Screen name is Already exist");
        }
        return mapper.map(screenRepository.save(screen), ScreenResponseDTO.class);
    }

    @Override
    public String deleteScreen(Long id) throws NotFoundException {
        Optional<Screen> screen = screenRepository.findById(id);

        if (!screen.isPresent()){
            throw new NotFoundException("There is no screen with this screen id ");
        }
        return "Deleted SuccessFully";
    }
}
