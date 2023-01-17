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
import com.ideas2it.ideas2movie.service.ScreenService;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     ScreenController
 * </h1>
 * <p>
 *
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
     *     Creates the Screen for the theater by the screenDTO and Validates according
     *     to Validation Constraints if the details of the Screen is not valid then
     *     the exception is thrown else process the request and return
     *     the response entity with HttpStatus created
     * </p>
     *
     * @param screenDTO - Holds the Details of Screen to create
     * @return ResponseEntity - Holds the ScreenResponseDTO and Http Status
     * @throws BadRequestException - when Given theater is Not exists
     * @throws AlreadyExistException - when Screen already Exist in that Theater
     */
    @PostMapping
    public ResponseEntity<ScreenResponseDTO> createScreen(@Valid @RequestBody ScreenDTO screenDTO)
            throws AlreadyExistException, BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(screenService.createScreen(screenDTO));
    }

    /**
     * <h1>
     *     updateScreen
     * </h1>
     * <p>
     *     Updates the Details of the Screen by the ID and ScreenDTO and validates according
     *     to Validation Constraints If Screen Details are not Valid then throws an Exception
     *     else process the request and returns the ResponseEntity with Http Status OK
     *     and updated Details of the Screen or throws an Exception If Screen not Found
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
     *
     * </p>
     *
     * @param id - ID of the Screen which need to be removed
     * @return ResponseEntity - Holds the String and Http Status
     * @throws NotFoundException - when Screen is Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeScreen(@PathVariable Long id) throws NotFoundException {
        String message = (!screenService.removeScreen(id)) ? Message.DELETED_SUCCESSFULLY : Message.FAILED_TO_DELETE;
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

}
