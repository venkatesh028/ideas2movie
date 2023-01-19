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

import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.service.MovieService;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h2>
 *     Movie Controller
 * </h2>
 * <p>
 *     MovieController provides the RESTful endpoints to Handle CRUD Operation and
 *     to know details of movie and validate the Information of the MovieDTO
 *     according to Validation constraints and throws an exception when occurred
 *     and returns the Details of Movie and Http Status
 * </p>
 *
 * @author Yogeshwar S
 * @version 1.0
 * @since 07-01-2023
 */
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    /**
     * <h1>
     *     Movie Controller Constructor
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also achieves the Autowiring
     * </p>
     *
     * @param movieService - An instance of Movie Service
     */
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * <h1>
     *
     * </h1>
     * <p>
     *     Add the Movie for the Theater by validating the MovieDTO
     *     according to validation constraints If Details of the Movie
     *     is Not Valid throws an exception else process the request and
     *     returns the ResponseEntity with Http status and Details of the Movie
     * </p>
     *
     * @param movieDTO - Holds the details of the movie
     * @return ResponseEntity - Holds the movieDTO and Http Status OK
     */
    @PostMapping
    public ResponseEntity<MovieResponseDTO> addMovie(@Valid @RequestBody MovieDTO movieDTO) {
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(movieService.addMovie(movieDTO));
    }

    /**
     * <h1>
     *     getMovieById
     * </h1>
     * <p>
     *     Retrieves the Details of the Movie by its ID and process the request
     *     If Movie is not found throws an exception otherwise returns the
     *     ResponseEntity with Http status OK and Details of the Movie
     * </p>
     *
     * @param id - ID of the Movie
     * @return ResponseEntity - Holds the MovieDTO and Http Status OK
     * @throws NotFoundException - when Movie is Not Found for ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable("id") Long id)
            throws NotFoundException {
        MovieResponseDTO fetchedMovie = movieService.getMovieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchedMovie);
    }

    /**
     * <h1>
     *     getMovieByName
     * </h1>
     * <p>
     *     Retrieves the Details of the Movie by its Name and process the request
     *     If Movie is not found throws an exception otherwise returns the
     *     ResponseEntity with Http status OK and Details of the Movie
     * </p>
     *
     * @param name - The name of the movie
     * @return MovieResponseDTO - Holds the MovieDTO and Http Status OK
     * @throws NotFoundException - when movie details is not Found
     */
   @GetMapping("/0f-movie/{name}")
    public ResponseEntity<MovieResponseDTO> getMovieByName(@PathVariable("name") String name)
           throws NotFoundException {
        MovieResponseDTO existByMovie = movieService.getMovieByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(existByMovie);
    }

    /**
     * <h1>
     *     getAllMovies
     * </h1>
     * <p>
     *     Retrieves the Details of All Movie which is exist in ideas2movie and process
     *     the request If Movies is not found throws an exception otherwise returns the
     *     ResponseEntity with Http status OK and Details of all movie
     *</p>
     *
     * @return List - Holds the MovieDTO and Http Status OK
     * @throws NoContentException - when list of movie is empty
     */
    @GetMapping
    public List<MovieResponseDTO> getAllMovies() throws NoContentException {
        return movieService.getAllMovies();
    }

    /**
     * <h1>
     *     updateMovie
     * </h1>
     * <p>
     *     Updates the Details of the Movie by the ID and MovieDTO and validates according
     *     to Validation Constraints If Movie Details are not Valid the throws an Exception
     *     else process the request and returns the ResponseEntity with Http Status OK
     *     and updated Details of the Movie or throws an Exception If Movie not Found
     *</p>
     *
     * @param id - ID of movie to update the Details of Movie
     * @param movieDTO - Holds the Details of the Movie
     * @return ResponseEntity - Holds the MovieResponseDTO and Http Status OK
     * @throws NotFoundException - when Movie not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> updateMovie(@Valid @PathVariable("id") Long id,
           @RequestBody MovieDTO movieDTO) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(movieService.updateMovie(id, movieDTO));
    }

    /**
     * <h1>
     *     deleteMovie
     * </h1>
     * <p>
     *     Delete the Movie by Id and returns ResponseEntity with Http status Ok
     *     and a String if Movie not found throws a exception
     *</p>
     *
     * @param id - The id of the Movie
     * @return ResponseEntity - Holds the String and Http Status OK
     * @throws NotFoundException - when Movie is not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id)
            throws NotFoundException  {

        if (!movieService.deleteMovie(id)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Message.DELETED_SUCCESSFULLY);
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Message.FAILED_TO_DELETE);
        }
    }
}
