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
import com.ideas2it.ideas2movie.service.ShowService;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotAcceptableException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     ShowController
 * </h1>
 * <p>
 *     Gets the inputs via Request from the client
 *     to perform Create, Update, Delete and Get
 *     the Show by sending the parameter/object
 *     to perform business logics on them
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

    @PostMapping
    public ResponseEntity<ShowResponseDTO> createShow(@Valid @RequestBody ShowDTO showDTO) throws AlreadyExistException,
                                                                                           NotFoundException,
                                                                                           NotAcceptableException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.createShow(showDTO)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowResponseDTO> getShow(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.getShowById(id));
    }

    @GetMapping("/movieName/{movieName}")
    public ResponseEntity<List<ShowResponseDTO>> getAllShowsByMovieName(@PathVariable String movieName)
                                                                                        throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.getAllShowsByMovieName(movieName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelShow(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(showService.cancelShow(id));
    }
}
