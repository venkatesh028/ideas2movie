/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Theater;
import com.ideas2it.ideas2movie.dto.TheaterDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TheaterResponseDTO;
import com.ideas2it.ideas2movie.service.TheaterService;
import com.ideas2it.ideas2movie.repository.TheaterRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h2>
 *     TheaterServiceImpl
 * </h2>
 * <p>
 *     Implements the TheaterService and
 *     Holds the Business Logic
 *     to Perform Save, and Get Theater
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 07
 * -01-2023
 */
@Service
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * <h1>
     *     Theater ServiceImpl Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for Theater Repository.
     * </p>
     *
     * @param theaterRepository- reference variable for Theater Repository
     */
    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TheaterResponseDTO addTheater(TheaterDTO theaterDTO)
            throws AlreadyExistException {
        if (theaterRepository.existsByTheaterName(theaterDTO.getTheaterName())
                && theaterRepository.existsByCity(theaterDTO.getCity()) &&
                theaterRepository.existsByArea(theaterDTO.getArea())) {
            throw new AlreadyExistException(Message.THEATER_ALREADY_REGISTERED);
        }
        Theater theater = modelMapper.map(theaterDTO, Theater.class);
        return modelMapper.map(theaterRepository.save(theater), TheaterResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TheaterResponseDTO> getAllTheaters()
            throws NoContentException {
        List<Theater> theaters = theaterRepository.findAll();

        if (theaters.isEmpty()) {
            throw  new NoContentException(Message.THEATER_NOT_FOUND);
        }
        List<TheaterResponseDTO> listOfTheater = new ArrayList<>();

        for (Theater theater: theaters) {
            listOfTheater.add(modelMapper.map(theater,
                    TheaterResponseDTO.class));
        }
        return listOfTheater;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TheaterResponseDTO getTheaterById(Long id) throws NotFoundException {
        Optional<Theater> theater = theaterRepository.findById(id);

        if (theater.isPresent()) {
            return modelMapper.map(theater.get(), TheaterResponseDTO.class);
        } else {
            throw new NotFoundException(Message.THEATER_NOT_FOUND);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Theater getTheaterForScreenById(Long id) throws NotFoundException {
        Optional<Theater> existingTheater = theaterRepository.findById(id);

        if (existingTheater.isPresent()) {
            return existingTheater.get();
        } else {
            throw new NotFoundException(Message.THEATER_NOT_FOUND);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TheaterResponseDTO updateTheater(Long id, TheaterDTO theaterDTO)
            throws NotFoundException, AlreadyExistException {
        Theater theater = modelMapper.map(theaterDTO, Theater.class);
        theater.setId(id);
        theater.setActive(true);
        Optional<Theater> existingTheater = theaterRepository.findById(id);

        if (existingTheater.isEmpty()) {
            throw new NotFoundException("No theater exist on given id");
        } else if (theaterRepository.existsByTheaterName(theater
          .getTheaterName()) && theaterRepository.existsByCity(theater
          .getCity()) && theaterRepository.existsByArea(theaterDTO.getArea())) {
            throw new AlreadyExistException(Message.FAILED_TO_UPDATE);
        } else {
            return modelMapper.map(theaterRepository.save(theater),
                    TheaterResponseDTO.class);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeTheater(Long id) throws NotFoundException {
        Optional<Theater> existingTheater = theaterRepository.findById(id);
        Theater theater;
        boolean isDeactivated;
        if (existingTheater.isPresent()) {
            theater = existingTheater.get();
            theater.setActive(false);
            theaterRepository.save(theater);
            return isDeactivated = true;
        }
        throw new NotFoundException(Message.THEATER_NOT_FOUND);
    }
}















