/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Movie;
import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.service.MovieService;
import com.ideas2it.ideas2movie.repository.MovieRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     MovieServiceImpl
 * </h1>
 * <p>
 *     Implements the MovieService and
 *     Holds the Business Logic
 *     to Perform Save, and Get Movie
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * <h1>
     *     Movie ServiceImpl Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for Movie Repository.
     * </p>
     *
     * @param movieRepository - reference variable for Movie Repository
     */
    public MovieServiceImpl( MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * {@inheritDoc}
     */
     @Override
    public MovieResponseDTO addMovie(MovieDTO movieDTO) {

        Movie movie = modelMapper.map(movieDTO, Movie.class);
        return modelMapper.map(movieRepository.save(movie),
                MovieResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MovieResponseDTO getMovieById(Long id) throws NotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);

        if (movie.isPresent()) {
            return modelMapper.map(movie.get(), MovieResponseDTO.class);
        } else {
            throw new NotFoundException(Message.MOVIE_NOT_FOUND);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MovieResponseDTO getMovieByName(String name) throws NotFoundException {
        Optional<Movie> existByMovie = movieRepository.findByName(name);

        if(existByMovie.isPresent()) {
            return modelMapper.map(existByMovie.get(), MovieResponseDTO.class);
        } else {
            throw new NotFoundException(Message.MOVIE_NOT_FOUND);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MovieResponseDTO> getAllMovies() throws NoContentException {
        List<Movie> movies = movieRepository.findAll();

        if (!movies.isEmpty()) {
            List<MovieResponseDTO> listOfMovies = new ArrayList<>();
            for(Movie movie: movies) {
                listOfMovies.add(modelMapper.map(movie, MovieResponseDTO.class));
            }
            return listOfMovies;
        }
        throw  new NoContentException(Message.MOVIE_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie getMovieByIdForShows(Long id) throws NotFoundException{
        Optional<Movie> existingMovies = movieRepository.findById(id);

        if (existingMovies.isPresent()) {
            return existingMovies.get();
        } else {
            throw new NotFoundException(Message.MOVIE_NOT_FOUND);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MovieResponseDTO updateMovie(Long id, MovieDTO movieDTO)
            throws  NotFoundException {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        movie.setId(id);
        Optional<Movie> existingMovie = movieRepository.findById(id);

        if (existingMovie.isPresent()) {
            return modelMapper.map(movieRepository.save(movie),
                    MovieResponseDTO.class);
        }
        throw new NotFoundException(Message.FAILED_TO_UPDATE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteMovie(Long id) throws NotFoundException {
        boolean isDeleted = true;
        boolean isAvailable = movieRepository.existsById(id);

        if (isAvailable) {
            movieRepository.deleteById(id);
            isDeleted = movieRepository.existsById(id);

            if (!isDeleted) {
                return isDeleted;
            }
        }
        throw new NotFoundException(Message.MOVIE_NOT_FOUND);
    }
}
