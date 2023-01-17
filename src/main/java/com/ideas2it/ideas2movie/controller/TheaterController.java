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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.ideas2it.ideas2movie.dto.TheaterDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TheaterResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.TheaterService;
import com.ideas2it.ideas2movie.util.constant.Constant;
import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h1>
 *     Theater Controller
 * </h1>
 * <p>
 *     TheaterController provides the RESTful endpoints to Handle CRUD Operation
 *     for Theater and validate the Information of the TheaterDTO according
 *     to Validation constraints and throws an exception when occurred
 *     and returns the Details of Theater and Http Status
 * </p>
 *
 * @author Yogeshwar S
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("api/v1/theaters")
public class TheaterController {
    private final TheaterService theaterService;

    /**
     * <h1>
     *     Theater Controller Constructor
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also achieves the Autowiring
     * </p>
     *
     * @param theaterService - An instance of Theater Service
     */
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    /**
     * <h1>
     *     addTheater
     * </h1>
     * <p>
     *     Create the Theater to run movies and validating the TheaterDTO
     *     according to validation constraints If Details of the Theater
     *     is Not Valid throws an exception else process the request and
     *     returns the ResponseEntity with Http status and Details of the Theater
     * </p>
     *
     * @param theaterDTO - Holds the details of the theater
     * @return ResponseEntity - Holds the theaterDTO and Http Status OK
     */
    @PostMapping
    public ResponseEntity<TheaterResponseDTO> addTheater(
            @RequestBody TheaterDTO theaterDTO) throws AlreadyExistException {
        Optional<TheaterResponseDTO> theaterDetails = theaterService.addTheater(theaterDTO);

        if (theaterDetails.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(theaterDetails.get());
        }
        throw new AlreadyExistException(Message.THEATER_ALREADY_REGISTERED);
    }

    /**
     * <h1>
     *     getTheaterById
     * </h1>
     * <p>
     *     Retrieves the Details of the Theater By the ID
     *     and process the request If the Theater is Not Found then
     *     throws an Exception otherwise returns the ResponseEntity
     *     with Http Status OK and Details of the Theater
     *</p>
     *
     * @param id - Id of the theater
     * @return ResponseEntity - Holds the TheaterDTO and Http Status OK
     * @throws NotFoundException - when theater details is not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<TheaterResponseDTO> getTheaterById(
            @PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(theaterService.getTheaterById(id));
    }

    /**
     * <h1>
     *     getAllTheaters
     * </h1>
     * <p>
     *     It returns a response entity with the fetched details of all
     *     theaters, if the list of theater is empty
     *     it will throw error message.
     *</p>
     *
     * @return A list of ResponseTheaterDTO objects - gives a response as list of theater details.
     * @throws NoContentException - occur when list of movie is empty
     */
    @GetMapping
    public List<TheaterResponseDTO> getAllTheaters() throws NoContentException {
        return theaterService.getAllTheaters();
    }

    /**
     * <h1>
     *     updateTheater
     * </h1>
     * <p>
     *     Updates the Details of the Theater by the ID and TheaterDTO and validates according
     *     to Validation Constraints If Theater Details are not Valid the throws an Exception
     *     else process the request and returns the ResponseEntity with Http Status OK
     *     and updated Details of the Theater or throws an Exception If Theater not Found
     *</p>
     *
     * @param id - ID of the Theater to update the Details of the Theater
     * @param theaterDTO - Holds the Details of the User
     * @return ResponseEntity - Holds the TheaterResponseDTO and Http Status OK
     * @throws AlreadyExistException -when theater name, city, area  already
     *                          registered with same details
     * @throws  NotFoundException - if theater not exist on a given id.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TheaterResponseDTO> updateTheater(@PathVariable("id") Long id,
                                             @RequestBody TheaterDTO theaterDTO) throws
            NotFoundException, AlreadyExistException {

        return ResponseEntity.status(HttpStatus.OK)
                .body(theaterService.updateTheater(id, theaterDTO));
    }

    /**
     * <h1>
     *     deleteTheater
     * </h1>
     * <p>
     *     Delete the Theater by Id and returns ResponseEntity with Http status Ok
     *     and a String if Theater not found throws a exception
     *</p>
     *
     * @param id The id of the Theater
     * @return ResponseEntity - Holds the String and Http Status OK
     * @throws NotFoundException - when Theater is not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable("id") Long id)
            throws NotFoundException  {
        return ResponseEntity.status(HttpStatus.OK).body(theaterService.deleteTheater(id));
    }
}


