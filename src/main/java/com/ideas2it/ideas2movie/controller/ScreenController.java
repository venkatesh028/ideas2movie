/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.service.ScreenService;
import com.ideas2it.ideas2movie.service.impl.ScreenServiceImpl;

/**
 * <h1>
 *     ScreenController
 * </h1>
 * <p>
 *     Gets the inputs via Request from the client
 *     to perform Create, Update, Delete and Get
 *     the Screen by sending the parameter/object
 *     to perform business logics on them
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
    public ResponseEntity<ScreenResponseDTO> createScreen(@RequestBody ScreenDTO screenDTO){
        return ResponseEntity.status(HttpStatus.OK).body(screenService.createScreen(screenDTO));
    }
    @PostMapping("/{id}")
    public ResponseEntity<ScreenResponseDTO> updateScreen(@RequestBody ScreenDTO screenDTO){
        return ResponseEntity.status(HttpStatus.OK).body();
    }
}
