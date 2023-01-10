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

import com.ideas2it.ideas2movie.dto.CastAndCrewDTO;
import com.ideas2it.ideas2movie.dto.responsedto.CastAndCrewResponseDTO;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.CastAndCrewService;

/**
 * <h1>
 *     CastAndCrew Controller
 * </h1>
 * <p>
 *     Gets the input parameter as a request from the Client
 *     to Get cast and crew Details of a particular movie
 *     by sending movie id as a request and also
 *     Gets the input parameter as a request from the Admin
 *     to create, update, delete cast and crew Details of a particular movie
 *     by sending those parameter or Object
 *     to the Theater Service to perform Business Logics on them
 * </p>
 *
 * @author Yogeshwar S
 * @version 1.0
 * @since 07-01-2023
 */

@RestController
@RequestMapping("api/v1/castandcrew")
public class CastAndCrewController {
    private final CastAndCrewService castAndCrewService;

    /**
     * <h1>
     *     CastAndCrew Controller Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for CastAndCrew service.
     * </p>
     *
     * @param castAndCrewService - reference variable for CastAndCrew Service
     */
     public CastAndCrewController(CastAndCrewService castAndCrewService) {
        this.castAndCrewService = castAndCrewService;
    }

    /**
     * <h1>
     *     addCastAndCrew
     * </h1>
     * <p>
     *     It takes a CastAndCrewResponseDTO object as a request body
     *     and calls the createCastAndCrew function in the castAndCrewService.
     *     If the castAndCrew of a movie is created, it returns the castAndCrewDTO object
     *</p>
     *
     * @param castAndCrewDTO The castAndCrewDto object that is to be added.
     * @return ResponseEntity<CastAndCrewResponseDTO> - gives a response as
     * castAndCrew details.
     */
    @PostMapping
    public ResponseEntity<CastAndCrewResponseDTO> addCastAndCrew(
            @RequestBody CastAndCrewDTO castAndCrewDTO)  {
        return ResponseEntity.status(HttpStatus.OK).body(castAndCrewService
                .addCastAndCrew(castAndCrewDTO));
    }

    /**
     * <h1>
     *     getCastAndCrewByMovieId
     * </h1>
     * <p>
     *     It takes an id of a movie as a path variable and
     *     fetches a cast and crew, returns a response entity
     *     with the fetched cast and crew of a movie
     *     if cast and crew of a particular movie is not present,
     *     it will throw error message.
     * </p>
     *
     * @param id The id of the movie to fetch cast and crew
     * @return ResponseEntity<CastAndCrewResponseDTO>  - give response as castAndCrew details
     * @throws NotFoundException - occur when cast and crew details is not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<CastAndCrewResponseDTO> getCastAndCrewByMovieId(
            @PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(castAndCrewService.getCastAndCrewByMovieId(id));
    }

    /**
     * <h1>
     *     updateCastAndCrew
     * </h1>
     * <p>
     *     It takes a CastAndCrewDTO object, id as a parameter,
     *     calls the updateCastAndCrew function in the CastAndCrewService
     *     and returns a ResponseEntity object with the updated CastAndCrew object
     *</p>
     *
     * @param id The id of castAndCrew
     * @param castAndCrewDTO The castAndCrewDTO object that needs to be updated
     * @return A ResponseEntity object - gives updated cast and crew object
     * @throws NotFoundException - it will throw the error message(N0 cast
     *                         and crew details exist to update on a given id)
     */
    @PostMapping("/{id}")
     public ResponseEntity<CastAndCrewResponseDTO> updateCastAndCrew(@PathVariable("id") Long id,
         @RequestBody CastAndCrewDTO castAndCrewDTO)
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
     *     It deletes a Cast and crew based on  id from  the database and
     *     returns a response entity with a status code of 200 and a body of the
     *     deleted status
     *</p>
     *
     * @param id The id of the user to be deleted.
     * @return ResponseEntity<String> - give a response as statement for delete castAndCrew.
     * @throws NotFoundException - Occur when cast and crew is not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCastAndCrew(@PathVariable("id") Long id)
            throws NotFoundException  {
        return ResponseEntity.status(HttpStatus.OK).body(castAndCrewService.deleteCastAndCrew(id));
    }
}
