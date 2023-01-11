/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.ScreenService;

/**
 * <h1>
 *     ScreenController
 * </h1>
 * <p>
 *     Gets the inputs via Request from the client
 *     to perform Create, Update, remove the Screen
 *     by sending the parameter/object to perform
 *     business logics on them
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

    @PostMapping
    public ResponseEntity<ScreenResponseDTO> createScreen(@Valid @RequestBody ScreenDTO screenDTO)
            throws NotFoundException, AlreadyExistException{
        return ResponseEntity.status(HttpStatus.OK).body(screenService.createScreen(screenDTO));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ScreenResponseDTO> updateScreen(@PathVariable Long id,
                                                          @Valid @RequestBody ScreenDTO screenDTO)
            throws NotFoundException, AlreadyExistException {
        return ResponseEntity.status(HttpStatus.OK).body(screenService.updateScreen(id, screenDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeScreen(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(screenService.removeScreen(id));
    }
}
