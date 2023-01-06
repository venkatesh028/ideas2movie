/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.repository.MovieRepository;
import com.ideas2it.ideas2movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    public MovieServiceImpl( MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public MovieResponseDTO getMovieById(MovieDTO movieDTO) {

    }
}
