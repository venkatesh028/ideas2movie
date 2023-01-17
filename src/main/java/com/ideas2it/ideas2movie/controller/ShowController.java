/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ShowResponseDTO;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NotAcceptableException;
import com.ideas2it.ideas2movie.service.ShowService;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     ShowController
 * </h1>
 * <p>
 *     Gets the Input as a Request from the Client and validates them
 *     to Create, Cancel and Get the Details of the Show by using the Instance of the showService
 *     and used to Handle and Mapping the request to appropriate function.
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService){
        this.showService = showService;
    }

    /**
     * <h1>
     *    createShow
     * </h1>
     * <p>
     *     Creates the Show For the screen by getting the details from ShowDTO and
     *     Validates according to Validation Constraints if the details of the show
     *     is not valid then the exception is thrown else process the request and
     *     return the response entity with HttpStatus created
     * </p>
     *
     * @param showDTO- Holds the details of the show to create
     * @return ResponseEntity - Holds the ShowResponseDTO and HttpStatus code
     * @throws AlreadyExistException - Throws When the Show is already exist for the same screen
     * @throws NotFoundException - Throws When movie or screen not found
     */
    @PostMapping
    public ResponseEntity<ShowResponseDTO> createShow(@Valid @RequestBody ShowDTO showDTO) throws AlreadyExistException,
            NotAcceptableException, BadRequestException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.createShow(showDTO)) ;
    }

    /**
     * <h1>
     *     getShow
     * </h1>
     * <p>
     *    Retrieves the Details of the show based on the id of the show
     *    by processing the request if there is no show with that id
     *    then exception is thrown Else return the response entity with
     *    HttpStatus Ok
     * </p>
     *
     * @param id - Holds the ID of the show
     * @return ResponseEntity - Holds the ShowResponseDTO and Http Status
     * @throws NotFoundException - when the Show is Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<ShowResponseDTO> getShow(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.getShowById(id));
    }

    /**
     *<h1>
     *     getShowsByScreenId
     *</h1>
     * <p>
     *     Retrieves the list of shows for the particular screen
     *     By the id of the screen if there is no shows available
     *     for the screen then exception is thrown
     * </p>
     * @param id - id of the screen
     * @return shows - Holds the list of shows for particular screen
     * @throws NoContentException - Occurs when there is no shows for the screen
     */
    @GetMapping("/of-screen/{id}")
    public ResponseEntity<List<ShowResponseDTO>> getShowsByScreenId(@PathVariable Long id)
            throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.getAllShowsByScreenId(id));
    }

    /**
     * <h1>
     *     getAllShowsByMovieName
     * </h1>
     * <p>
     *     Retrieves All the shows for the Particular Movie based on
     *     The name of that movie if there is no shows for that movie
     *     then exception is thrown else return the ResponseEntity with
     *     HttpStatus OK
     * </p>
     * @param movieName - Holds the name of the movie
     * @return ResponseEntity - Holds the List of ShowResponseDTO and Http Status
     * @throws NoContentException - Occurs When there is No content for the requested resources
     */
    @GetMapping("/of-movie/{movieName}")
    public ResponseEntity<List<ShowResponseDTO>> getAllShowsByMovieName(@PathVariable String movieName)
                                                                                        throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.getAllShowsByMovieName(movieName));
    }

    /**
     * <h1>
     *     cancelShow
     * </h1>
     * <p>
     *     Gets the PathVariable to Cancel the Show for the Show ID
     *     by process the request by sending to showService and returns the List of ShowResponseDTO
     *     and Http Status or throws an Exception accordingly when occurred
     * </p>
     *
     * @param id - ID of the Show to cancel the Show
     * @return ResponseEntity - Holds the String and Http Status
     * @throws NotFoundException - when Show is Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelShow(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.cancelShow(id));
    }
}
