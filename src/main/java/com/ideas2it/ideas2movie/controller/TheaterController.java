/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.ideas2it.ideas2movie.dto.TheaterDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TheaterResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.TheaterService;
@RestController
@RequestMapping("api/v1/theater")
public class TheaterController {
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }
    @PostMapping
    public ResponseEntity<TheaterDTO> createTheater(@RequestBody TheaterDTO theaterDTO)
            throws AlreadyExistException {
        Optional<TheaterDTO> theaterDetails = theaterService.createTheater(theaterDTO);
        if ( theaterDetails.isPresent() ) {
            return ResponseEntity.status(HttpStatus.OK).body(theaterDetails.get());
        }
        throw new AlreadyExistException("Theater not created");
    }
    @GetMapping("/{id}")
    public ResponseEntity<TheaterResponseDTO> getTheaterById(@PathVariable("id") Long id) throws NotFoundException {
        TheaterResponseDTO fetchedTheater = theaterService.getTheaterById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchedTheater);
    }

    @GetMapping
    public List<TheaterResponseDTO> getAllTheaters() throws NotFoundException {
        return theaterService.getAllTheater();
    }
}


