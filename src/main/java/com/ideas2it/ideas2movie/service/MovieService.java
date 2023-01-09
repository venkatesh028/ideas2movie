/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
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
    MovieResponseDTO addMovie(MovieDTO movieDTO);

    MovieResponseDTO getMovieById(Long id) throws NotFoundException;

    List<MovieResponseDTO> getAllMovies() throws NotFoundException;


    Movie getMovieByIdForShows(Long id) throws NotFoundException;

    MovieResponseDTO updateMovie(Long id, MovieDTO movieDTO) throws NotFoundException;

    String  deleteMovie(Long id) throws NotFoundException;
}
