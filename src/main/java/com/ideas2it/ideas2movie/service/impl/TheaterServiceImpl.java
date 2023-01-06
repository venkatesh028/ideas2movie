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
    public Optional<TheaterDTO> createTheater(TheaterDTO theaterDTO)
            throws AlreadyExistException {

        if (theaterRepository.existsByTheaterName(theaterDTO.getTheaterName())
                && theaterRepository.existsByTheaterCity(theaterDTO.getCity())) {
            throw new AlreadyExistException("This Theatre is already exist");
        } else {
            Theater theater = modelMapper.map(theaterDTO, Theater.class);
            theater.setTheaterName(theater.getTheaterName());
            theater.setCity(theater.getCity());
            theater.setPincode(theater.getPincode());
            theater.setArea(theater.getArea());
            theater.setCreatedAt(theater.getCreatedAt());
            theater.setUpdatedAt(theater.getUpdatedAt());
            return Optional.of(modelMapper.map(theaterRepository.save(theater),
                    TheaterDTO.class));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TheaterResponseDTO> getAllTheater() throws NotFoundException{
        List<Theater> theaters = theaterRepository.findAll();

        if (!theaters.isEmpty()) {
            List<TheaterResponseDTO> listOfTheater = new ArrayList<>();
            for(Theater theater: theaters) {
                listOfTheater.add(modelMapper.map(theater, TheaterResponseDTO.class));
            }
            return listOfTheater;
        }
        throw  new NotFoundException("No theater is exist");
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
            throw new NotFoundException("No theater exist on a given id");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TheaterDTO updateTheater(TheaterDTO theaterDto)
            throws NotFoundException {

        if (null == theaterDto) {
            throw new NotFoundException("No theater exist  on given id");
        }
        return new TheaterDTO();
    }

}















