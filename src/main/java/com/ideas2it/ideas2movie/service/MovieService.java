/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.MovieDTO;
import com.ideas2it.ideas2movie.dto.responsedto.MovieResponseDTO;
import com.ideas2it.ideas2movie.model.Movie;

public interface MovieService {

    public MovieResponseDTO getMovieById(MovieDTO movieDTO);

    MovieResponseDTO createMovie(MovieDTO movieDTO);
    Movie getMovieByIdForShows(Long id);
}
