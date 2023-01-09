/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ideas2it.ideas2movie.dto.TheaterDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TheaterResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.model.Theater;
import com.ideas2it.ideas2movie.repository.TheaterRepository;
import com.ideas2it.ideas2movie.service.TheaterService;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.util.constant.Message;

@Service
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<TheaterResponseDTO> addTheater(TheaterDTO theaterDTO)
            throws AlreadyExistException {

        if (theaterRepository.existsByTheaterName(theaterDTO.getTheaterName())
                && theaterRepository.existsByCity(theaterDTO.getCity()) &&
                theaterRepository.existsByArea(theaterDTO.getArea())) {
            throw new AlreadyExistException(Message.THEATER_ALREADY_REGISTERED);
        } else {
            Theater theater = modelMapper.map(theaterDTO, Theater.class);
            return Optional.of(modelMapper.map(theaterRepository.save(theater),
                    TheaterResponseDTO.class));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TheaterResponseDTO> getAllTheaters() throws NotFoundException{
        List<Theater> theaters = theaterRepository.findAll();

        if (!theaters.isEmpty()) {
            List<TheaterResponseDTO> listOfTheater = new ArrayList<>();
            for (Theater theater: theaters) {
                listOfTheater.add(modelMapper.map(theater, TheaterResponseDTO.class));
            }
            return listOfTheater;
        }
        throw  new NotFoundException(Message.THEATER_NOT_FOUND);
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
        Optional<Theater> existingTheater = theaterRepository.findById(id);

        if (!existingTheater.isPresent()) {
            throw new NotFoundException("No theater exist on given id");
        } else if (theaterRepository.existsByTheaterName(theater.getTheaterName()) &&
                theaterRepository.existsByCity(theater.getCity()) &&
                theaterRepository.existsByArea(theaterDTO.getArea())) {
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
    public String deleteTheater(Long id) throws NotFoundException {
        Optional<Theater> existingTheater = theaterRepository.findById(id);

        if (existingTheater.isPresent() && existingTheater.get().isActive()) {
            existingTheater.get().setActive(false);
            if (!existingTheater.get().isActive()) {
                return Message.DELETED_SUCCESSFULLY ;
            }
        }
        throw new NotFoundException(Message.FAILED_TO_DELETE);
    }
}















