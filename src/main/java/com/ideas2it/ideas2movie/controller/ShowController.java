package com.ideas2it.ideas2movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.service.ShowService;
import com.ideas2it.ideas2movie.service.impl.ShowServiceImpl;

@RestController
@RequestMapping("/api/v1/show")
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowServiceImpl showServiceImpl){
        this.showService = showServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody ShowDTO showDTO){
        return new ResponseEntity<>(showService.createShow(showDTO), HttpStatus.OK);
    }

}
