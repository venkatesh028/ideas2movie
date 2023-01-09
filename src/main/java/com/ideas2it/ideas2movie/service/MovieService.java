/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Movie;

/**
 * <h1>
 *     Movie Service Interface
 * </h1>
 * <p>
 *     Service Layer for the Movie
 *     to Create, and Get the movie details
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 06-01-2023
 */
public interface MovieService {

    /**
     * <p>
     *  Add the Movie details to ideas2movie.
     * </p>
     *
     * @param movieDTO it contains details of the movie to be added to ideas2movie.
     * @return movieResponseDto - after store in ideas2movie, to give a response as movie details.
     */
    MovieResponseDTO addMovie(MovieDTO movieDTO);

    /**
     * <p>
     * check the given movie id is exist in ideas2movie
     * if it exist get the Movie Details based on id.
     * </p>
     *
     * @param id - id of the movie to be fetched from ideas2movie
     * @return movieResponseDto - gives a response of movie details based on movie id
     * @throws NotFoundException - occur when no movie is existing in ideas2movie on a given id
     */
    MovieResponseDTO getMovieById(Long id) throws NotFoundException;

    /**
     * <p>
     * Get all the Movies which is registered in ideas2movie
     * </p>
     *
     * @return List<MovieResponseDto> gives a response of all movie details
     * @throws NoContentException - occur when no movies existing in ides2movie
     */
    List<MovieResponseDTO> getAllMovies() throws NoContentException;

    /**
     * <p>
     * check the given movie id is exist in ideas2movie
     * if it exist get the Movie Details for shows.
     * </p>
     *
     * @param id - id of the movie to be fetched from ideas2movie
     * @return movieResponseDto - gives a response of movie details based on movie id
     * @throws NotFoundException - occur when no movie is existing in ideas2movie on a given id
     */
    Movie getMovieByIdForShows(Long id) throws NotFoundException;

    /**
     * <p>
     * Check the given movie id exist in ideas2movie if it exist
     * update the movie details and send the updated movieResponseDTO.
     * </p>
     *
     * @param id - id of the movie to be updated
     * @param movieDTO it contains movie details
     * @return movieResponseDto - gives a response of updated movie details based on id
     * @throws NotFoundException - if the given movie id is not exist in ideas2movie
     */
    MovieResponseDTO updateMovie(Long id, MovieDTO movieDTO) throws NotFoundException;

    /**
     * <p>
     * Check the given movie id exist in ideas2movie if it exist delete the movie details
     * and send the deleted success message.
     * </p>
     *
     * @param id of movie to be deleted.
     * @return delete message if theater deleted successfully
     * @throws NotFoundException - occur when id is not exist in ideas2movie.
     */
    String  deleteMovie(Long id) throws NotFoundException;
}
