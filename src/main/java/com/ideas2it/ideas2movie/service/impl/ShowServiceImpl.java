/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ShowResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.repository.ShowRepository;
import com.ideas2it.ideas2movie.service.MovieService;
import com.ideas2it.ideas2movie.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final MovieService movieService;

    public ShowServiceImpl(ShowRepository showRepository,MovieService movieService){
        this.showRepository = showRepository;
        this.movieService = movieService;
    }

    public ShowResponseDTO createShow(ShowDTO showDTO) throws AlreadyExistException {
        Show show = mapper.map(showDTO, Show.class);

        if (showRepository.existsByDateAndTimeAndMovieId(showDTO.getStreamingDate(),
                                                         showDTO.getStartTime(),
                                                         showDTO.getMovieId())){
            throw new AlreadyExistException("This is Show is Already Active");

        }
        return mapper.map(showRepository.save(show), ShowResponseDTO.class);
    }

    public ShowResponseDTO updateShow(ShowDTO showDTO) {
        Show show = mapper.map(showDTO, Show.class);
        return new ShowResponseDTO();
    }

    public List<ShowResponseDTO> getShowsByMovieId(String movieName) throws NotFoundException {
        List<Show> availableShows = List.of(showRepository.findAllByMovieName(movieName));
        List<ShowResponseDTO> shows = new ArrayList<>() ;

        if (availableShows.isEmpty()){
            throw new NotFoundException("There is No Show with this movie name");
        }

        for(Show show: availableShows){
            shows.add(mapper.map(show, ShowResponseDTO.class));
        }
        return shows;
    }

}
