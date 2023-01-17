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

import com.ideas2it.ideas2movie.dto.CastAndCrewDTO;
import com.ideas2it.ideas2movie.dto.responsedto.CastAndCrewResponseDTO;
import com.ideas2it.ideas2movie.service.CastAndCrewService;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h1>
 *     CastAndCrew Controller
 * </h1>
 * <p>
 *     CastAndCrewController provides the RESTful endpoints to Handle CRUD Operation and to
 *     add the cast and crew details for a movie and validate the Information of the CastAndCrewDTO
 *     according to Validation constraints and throws an exception when occurred
 *     and returns the Details of CastAndCrew and Http Status
 * </p>
 *
 * @author Yogeshwar S
 * @version 1.0
 * @since 07-01-2023
 */
@RestController
@RequestMapping("api/v1/casts-and-crews")
public class CastAndCrewController {
    private final CastAndCrewService castAndCrewService;

    /**
     * <h1>
     *     CastAndCrew Controller Constructor
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also to achieves the Autowiring
     * </p>
     *
     * @param castAndCrewService - An instance of the CastAndCrew Service
     */
     public CastAndCrewController(CastAndCrewService castAndCrewService) {
        this.castAndCrewService = castAndCrewService;
    }

    /**
     * <h1>
     *     addCastAndCrew
     * </h1>
     * <p>
     *    Add the cast and crew for the movie by validating the CastAndCrewDTO,
     *    according to validation constraints If Details of the CastAndCrew
     *    is Not Valid throws an exception else process the request and
     *    returns the ResponseEntity with Http status and Details of the CastAndCrew
     *</p>
     *
     * @param castAndCrewDTO - Holds the details of castAndCrew
     * @return ResponseEntity - Holds the castAndCrewDTO and Http Status OK
     */
    @PostMapping
    public ResponseEntity<CastAndCrewResponseDTO> addCastAndCrew(
            @RequestBody CastAndCrewDTO castAndCrewDTO)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(castAndCrewService
                .addCastAndCrew(castAndCrewDTO));
    }

    /**
     * <h1>
     *     getCastAndCrewById
     * </h1>
     * <p>
     *     Retrieves the Details of the castAndCrew by its ID and process the request
     *     If castAndCrew is not found throws an exception otherwise returns the
     *     ResponseEntity with Http status OK and Details of the castAndCrew
     * </p>
     *
     * @param id - Id of the CastAndCrew
     * @return ResponseEntity - Holds the CastAndCrewResponseDTO and Http Status OK
     * @throws NotFoundException - when CastAndCrew is Not Found for by its ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<CastAndCrewResponseDTO> getCastAndCrewId(
            @PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(castAndCrewService.getCastAndCrewById(id));
    }

    /**
     * <h1>
     *     updateCastAndCrew
     * </h1>
     * <p>
     *     Updates the Details of the CastAndCrew by the ID and CastAndCrewDTO and validates according
     *     to Validation Constraints If CastAndCrew Details are not Valid the throws an Exception
     *     else process the request and returns the ResponseEntity with Http Status OK
     *     and updated Details of the CastAndCrew or throws an Exception If CastAndCrew not Found
     * </p>
     *
     * @param id - The id of castAndCrew to update the Details of CastAndCrew
     * @param castAndCrewDTO - Holds the Details of the CastAndCrewDTO
     * @return ResponseEntity - Holds the  CastAndCrewResponseDTO and Http Status OK
     * @throws NotFoundException - when CastAndCrew not found
     */
    @PutMapping("/{id}")
     public ResponseEntity<CastAndCrewResponseDTO> updateCastAndCrew(
            @PathVariable("id") Long id, @RequestBody CastAndCrewDTO castAndCrewDTO)
            throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(castAndCrewService.updateCastAndCrew(id,
                        castAndCrewDTO));
    }

    /**
     * <h1>
     *     deleteCastAndCrew
     * </h1>
     * <p>
     *     Delete the CastAndCrew by Id and returns ResponseEntity with Http status Ok
     *     and a String if theater not found throws a exception
     *</p>
     *
     * @param id The id of the CastAndCrew
     * @return boolean
     * @throws NotFoundException - when CastAndCrew not is not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCastAndCrew(@PathVariable("id") Long id)
            throws NotFoundException {
        if (!castAndCrewService.deleteCastAndCrew(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(Message.DELETED_SUCCESSFULLY);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(Message.FAILED_TO_DELETE);
        }
    }
}
