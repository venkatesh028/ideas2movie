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

import java.util.List;

import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.MovieService;

/**
 * <h1>
 *     Movie Controller
 * </h1>
 * <p>
 *     Gets the input parameter as a request from the Client
 *     to Get  Details of a particular movie
 *     by sending movie id as a request and also
 *     Gets the input parameter as a request from the Admin
 *     to create, update, delete details of a particular movie
 *     by sending those parameter or Object
 *     to the Movie Service to perform Business  Logics on them
 * </p>
 *
 * @author Yogeshwar S
 * @version 1.0
 * @since 07-01-2023
 */
@RestController
public class MovieController {
    private final MovieService movieService;

    /**
     * <h1>
     *     Movie Controller Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for Movie service.
     * </p>
     *
     * @param movieService - reference variable for Movie Service
     */
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * It takes a MovieDTO object as a request body
     * and then calls the creatMovie function in the movieService.
     * If the details of a movie is created, it returns the movieDTO object
     *
     * @param movieDTO The MovieDto object that is to be added.
     * @return ResponseEntity<MovieResponseDTO> - gives a response as
     * movie details.
     */
    @RequestMapping
    public ResponseEntity<MovieResponseDTO> addMovie
            (@RequestBody MovieDTO movieDTO) {
        return  ResponseEntity.status(HttpStatus.OK)
                .body(movieService.addMovie(movieDTO));
    }

    /**
     * It takes an id of a movie as a path variable and fetches a movie details
     * returns a response entity with the fetched details of a movie
     * if details of a particular movie is not present,
     * it will throw error message (no movie exist for a given movie id)
     *
     * @param id The id of the movie to fetch a movie details
     * @return ResponseEntity<MovieResponseDTO>  - give response as movie details
     * @throws NotFoundException - occur when movie details is not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(
            @PathVariable("id") Long id) throws NotFoundException {
        MovieResponseDTO fetchedMovie = movieService.getMovieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchedMovie);
    }

    /**
     * It returns a list of all movies.
     *
     * @return A list of ResponseMovieDTO objects  - gives a response as list of movie details.
     * @throws NoContentException  - occur when list of movie is empty
     */
    @GetMapping
    public List<MovieResponseDTO> getAllMovies() throws NoContentException {
        return movieService.getAllMovies();
    }

    /**
     * It takes a MovieDTO object, id as a parameter, calls the updateMovie function
     * in the movieService and returns a ResponseEntity object with the updated movie object
     *
     * @param id The id of movie
     * @param movieDTO The movieDTO object that needs to be updated
     * @return A ResponseEntity object - gives updated movie object
     * @throws NotFoundException - it will throw the error message(N0 movie
     *                          details exist to update on a given id)
     */
    @PostMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> update(@PathVariable("id") Long id,
                                                     @RequestBody MovieDTO movieDTO) throws
            NotFoundException {

        return ResponseEntity.status(HttpStatus.OK)
                .body(movieService.updateMovie(id, movieDTO));
    }

    /**
     * It deletes a movie details based on  id from  the database and
     * returns a response entity with a status code of 200 and a body of the
     * deleted status
     *
     * @param id The id of the movie to be deleted.
     * @return ResponseEntity<String> - give a response as statement for deleted movie.
     * @throws NotFoundException - Occur when movie is not found on a given id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable("id") Long id)
            throws NotFoundException  {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.deleteMovie(id));
    }
}
