/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Movie;
import com.ideas2it.ideas2movie.repository.MovieRepository;
import com.ideas2it.ideas2movie.service.MovieService;
import com.ideas2it.ideas2movie.util.constant.Message;

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

     @Override
    public MovieResponseDTO addMovie(MovieDTO movieDTO) {

        Movie movie = modelMapper.map(movieDTO, Movie.class);
        return modelMapper.map(movieRepository.save(movie),
                MovieResponseDTO.class);
    }

    @Override
    public MovieResponseDTO getMovieById(Long id) throws NotFoundException {
        Optional<Movie> movies = movieRepository.findById(id);

        if (movies.isPresent()) {
            return modelMapper.map(movies.get(), MovieResponseDTO.class);
        } else {
            throw new NotFoundException("No movie exist on a given id");
        }
    }

    @Override
    public List<MovieResponseDTO> getAllMovies() throws NotFoundException{
        List<Movie> movies = movieRepository.findAll();

        if (!movies.isEmpty()) {
            List<MovieResponseDTO> listOfMovies = new ArrayList<>();
            for(Movie movie: movies) {
                listOfMovies.add(modelMapper.map(movie, MovieResponseDTO.class));
            }
            return listOfMovies;
        }
        throw  new NotFoundException("No theater is exist");
    }

    @Override
    public Movie getMovieByIdForShows(Long id) throws NotFoundException{
        Optional<Movie> existingMovies = movieRepository.findById(id);

        if (existingMovies.isPresent()) {
            return existingMovies.get();
        } else {
            throw new NotFoundException("No movie exist on a given id");
        }
    }
    @Override
    public MovieResponseDTO updateMovie(Long id, MovieDTO movieDTO)
            throws  NotFoundException {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        Optional<Movie> existingMovie = movieRepository.findById(id);

        if (existingMovie.isPresent()) {
            return modelMapper.map(movieRepository.save(movie),
                    MovieResponseDTO.class);
        }
        throw new NotFoundException(Message.FAILED_TO_UPDATE);
    }
    @Override
    public String deleteMovie(Long id) throws NotFoundException {
        Optional<Movie> existingMovie = movieRepository.findById(id);

        if (existingMovie.isPresent()) {
            movieRepository.deleteById(id);
            if (!existingMovie.isPresent()) {
                return Message.DELETED_SUCCESSFULLY;
            }
        }
        throw new NotFoundException(Message.FAILED_TO_DELETE);
    }
}
