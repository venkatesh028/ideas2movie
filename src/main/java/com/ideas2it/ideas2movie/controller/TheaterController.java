/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
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

/**
 * <h1>
 *     Theater Controller
 * </h1>
 * <p>
 *     Gets the input parameter as a request from the Client
 *     to Get Theater Details of a particular theater
 *     by sending theater id as a request and also
 *     Gets the input parameter as a request from the Admin
 *     to create, update, delete theater Details of a particular movie
 *     by sending those parameter or Object
 *     to the Theater Service to perform Business Logics on them
 * </p>
 *
 * @author Yogeshwar S
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("api/v1/theater")
public class TheaterController {
    private final TheaterService theaterService;

    /**
     * <h1>
     *     Theater Controller Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for Theater service.
     * </p>
     *
     * @param theaterService - reference variable for Theater Service
     */
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    /**
     * It takes a TheaterDTO object as a parameter, validates it,
     * and then calls the addMovie function in the theaterService.
     * If the theater is added, it returns the theater object,
     * else it throws a Already exist exception
     *
     * @param theaterDTO The theaterDTO object that is to be added.
     * @return ResponseEntity<TheaterDTO> - gives a response as theater details
     * @throws AlreadyExistException- occur when theater's name and city are already registered
     */
    @PostMapping
    public ResponseEntity<TheaterResponseDTO> addTheater(
            @RequestBody TheaterDTO theaterDTO) throws AlreadyExistException {
        Optional<TheaterResponseDTO> theaterDetails = theaterService.addTheater(theaterDTO);

        if (theaterDetails.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(theaterDetails.get());
        }
        throw new AlreadyExistException("Theater not created");
    }

    /**
     * It takes an id of a theater as a parameter and fetches a theater details
     * returns a response entity with the fetched details of a theater
     * if details of a particular theater is not present,
     * it will throw error message (no theater exist for a given movie id)
     *
     * @param id The id of the theater to fetch a theater details
     * @return ResponseEntity<MovieResponseDTO>  - give response as theater details
     * @throws NotFoundException - occur when theater details is not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<TheaterResponseDTO> getTheaterById(
            @PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(theaterService.getTheaterById(id));
    }

    /**
     * It returns a list of all theaters.
     *
     * @return A list of ResponseTheaterDTO objects - gives a response as list of theater details.
     * @throws NotFoundException - occur when list of movie is empty
     */
    @GetMapping
    public List<TheaterResponseDTO> getAllTheaters() throws NotFoundException {
        return theaterService.getAllTheaters();
    }

    /**
     * It takes a TheaterDTO object, id as a parameter, calls the updateTheater function
     * in the theaterService class, and returns a ResponseEntity object with the updated theater details
     *
     * @param theaterDTO The theaterDTO object that needs to be updated.
     * @param id The id of theater that needs to be updated.
     * @return A ResponseEntity object is being returned - gives update response statement.
     * @throws AlreadyExistException - validate the theater name and city before update it,
     *                         if it exists, it will throw the error message.
     * @throws  NotFoundException - if theater details not exist.
     */
    @PostMapping("/{id}")
    public ResponseEntity<TheaterResponseDTO> update(@PathVariable("id") Long id,
                                             @RequestBody TheaterDTO theaterDTO) throws
            NotFoundException, AlreadyExistException {

        return ResponseEntity.status(HttpStatus.OK)
                .body(theaterService.updateTheater(id, theaterDTO));
    }

    /**
     * It deletes a theater details based on  id from  the database and
     * returns a response entity with a status code of 200 and a body of the
     * deleted status
     *
     * @param id The id of the theater to be deleted.
     * @return ResponseEntity<String> - give a response as statement for deleted theater.
     * @throws NotFoundException - Occur when theater is not found on a given id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable("id") Long id)
            throws NotFoundException  {
        return ResponseEntity.status(HttpStatus.OK).body(theaterService.deleteTheater(id));
    }
}


