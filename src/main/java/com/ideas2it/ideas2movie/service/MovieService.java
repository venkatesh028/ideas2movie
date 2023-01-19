/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.model.Movie;
import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h2>
 *     MovieService
 * </h2>
 * <p>
 *     MovieService provides the Methods for Movie CRUD Operation
 *     and throws an Exceptions when occurred
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 06-01-2023
 */
public interface MovieService {

    /**
     * <h1>
     *     addMovie
     * </h1>
     * <p>
     *     Create Movie details and add the Movie
     *     details to ideas2movie.
     * </p>
     *
     * @param movieDTO - Holds details of the movie.
     * @return movieResponseDto - Holds the created movie details.
     */
    MovieResponseDTO addMovie(MovieDTO movieDTO);

    /**
     * <h1>
     *     getMovieById
     * </h1>
     * <p>
     *     Get the Movie details on given Movie Id, if id not
     *     exist in ideas2movie then throws an Exception.
     * </p>
     *
     * @param id - Id of the Movie to be fetched from ideas2movie
     * @return MovieResponseDto - Holds fetched Movie details of a Movie Id
     * @throws NotFoundException - Occur when no Movie details is existing
     *                         in ideas2movie on a given id
     */
    MovieResponseDTO getMovieById(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getMovieByName
     * </h1>
     * <p>
     *     Get the Movie details on given Movie Name, if Movie Name not
     *     exist in ideas2movie then throws an Exception.
     * </p>
     *
     * @param name - Name of the Movie, to be fetched from ideas2movie
     * @return MovieResponseDto - Holds fetched Movie details of a Movie Name
     * @throws NotFoundException - Occur when no Movie details is existing
     *                         in ideas2movie on a given id
     */
    MovieResponseDTO getMovieByName(String name) throws NotFoundException;

    /**
     * <h1>
     *     getAllMovies
     * </h1>
     * <p>
     *     Get all the Movies which is registered in ideas2movie and
     *     throws exception when occur
     * </p>
     *
     * @return MovieResponseDto - Holds all Movie details registered in ideas2movie
     * @throws NoContentException - Occur when no Movies existing in ides2movie
     */
    List<MovieResponseDTO> getAllMovies() throws NoContentException;

    /**
     * <h1>
     *     getMovieByIdForShows
     * </h1>
     * <p>
     *     Get the Movie details on given Movie Id for Shows, if id not
     *     exist in ideas2movie then throws an Exception.
     * </p>
     *
     * @param id - Id of the Movie to be fetched from ideas2movie
     * @return MovieResponseDto - Holds created Movie details
     * @throws NotFoundException - Occur when no Movie details is existing
     *                         in ideas2movie on a given id
     */
    Movie getMovieByIdForShows(Long id) throws NotFoundException;

    /**
     * <h1>
     *     updateMovie
     * </h1>
     * <p>
     *     Update Movie details and add the updated Movie
     *     details to ideas2movie and throws Exception when occur.
     * </p>
     *
     * @param id - Id of the Movie to be Updated
     * @return movieResponseDto - Holds the Updated movie details.
     * @throws NotFoundException - occur when id is not exist in ideas2movie.
     */
    MovieResponseDTO updateMovie(Long id, MovieDTO movieDTO)
            throws NotFoundException;

/**
 * <h1>
 *     deleteMovie
 * </h1>
 * <p>
 *     Delete the Movie details based on Movie Id
 *     if Id exist delete the Movie else throw an
 *     Exception.
 * </p>
 *
 * @param id - ID of Movie to be deleted.
 * @return boolean - If Movie deleted successfully return true or else false
 * @throws NotFoundException - Occur when id not exist in ideas2movie.
 */
    boolean  deleteMovie(Long id) throws NotFoundException;
}
