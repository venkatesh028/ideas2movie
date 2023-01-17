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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.ScreenService;

/**
 * <h1>
 *     ScreenController
 * </h1>
 * <p>
 *     Gets the input as a Request from the Client and Validates them
 *     to Create, Update, get and Remove the Details of the Screen by the Instance of the screenService
 *     and used to Handle and Mapping the Request to appropriate function
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@RestController
@RequestMapping("/api/v1/screens")
public class ScreenController {
    private final ScreenService screenService;
    public ScreenController(ScreenService screenService){
        this.screenService = screenService;
    }

    /**
     * <h1>
     *      createScreen
     * </h1>
     * <p>
     *      Gets the RequestBody to create Screen and validates them according to Validation Constraints
     *      and process the request by sending to ScreenService and returns the ScreenResponseDTO
     *      and Http Status or throws an exception accordingly when occurred
     * </p>
     *
     * @param screenDTO - Holds the Details of Screen to create
     * @return ResponseEntity - Holds the ScreenResponseDTO and Http Status
     * @throws NotFoundException - when Theater is Not Found
     * @throws AlreadyExistException - when Screen already Exist in that Theater
     */
    @PostMapping
    public ResponseEntity<ScreenResponseDTO> createScreen(@Valid @RequestBody ScreenDTO screenDTO)
            throws AlreadyExistException, BadRequestException {
        return ResponseEntity.status(HttpStatus.OK).body(screenService.createScreen(screenDTO));
    }

    /**
     * <h1>
     *     updateScreen
     * </h1>
     * <p>
     *     Gets the PathVariable and RequestBody to Update the Details of the Screen
     *     and Validates them according to Validation Constraints and process the request
     *     by sending to ScreenService and returns the ScreenResponseDTO and Http Status
     *     or throws an exception accordingly when occurred
     * </p>
     *
     * @param id - ID of the Screen to Update the Details of Screen
     * @param screenDTO - Details of the Screen to Update
     * @return ResponseEntity - Holds the ScreenResponseEntity and Http Status
     * @throws NotFoundException - when Screen Not Found
     * @throws AlreadyExistException - when Screen Details already Exist in that Theater
     */
    @PutMapping("/{id}")
    public ResponseEntity<ScreenResponseDTO> updateScreen(@PathVariable Long id,
                                                          @Valid @RequestBody ScreenDTO screenDTO)
            throws NotFoundException, AlreadyExistException, BadRequestException {
        return ResponseEntity.status(HttpStatus.OK).body(screenService.updateScreen(id, screenDTO));
    }

    /**
     * <h1>
     *     getAllScreenByTheaterId
     * </h1>
     * <p>
     *      Retrieves the Details of the Screen By the ID of the Theater
     *      by processing the request if there is no screen exist for
     *      that theater then exception is thrown
     * </p>
     * @param id - Holds the id of the theater
     * @return listOfScreen - Holds the list of screen of the particular theater
     * @throws NoContentException - Occurs when there is no screen for that theater
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<ScreenResponseDTO>> getAllScreenByTheaterId(@PathVariable Long id)
            throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(screenService.getScreensByTheaterId(id));
    }

    /**
     * <h1>
     *     removeScreen
     * </h1>
     * <p>
     *     Gets the PathVariable to remove Screen from Theater and process the request
     *     by sending to ScreenService and returns the String and Http Status
     *     or throws an Exception accordingly when occurred
     * </p>
     *
     * @param id - ID of the Screen which need to be removed
     * @return ResponseEntity - Holds the String and Http Status
     * @throws NotFoundException - when Screen is Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeScreen(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(screenService.removeScreen(id));
    }

}
