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

/**
 * <h1>
 *     Show Service Impl
 * </h1>
 * <p>
 *     Implements the Show Service and
 *     Holds the Business Logics
 *     to Create, Update, Delete, Get the Details of the Show
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
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

        if (showRepository.existsByDateAndTimeAndScreenId(showDTO.getStreamingDate(),
                                                          showDTO.getStartTime(),
                                                          showDTO.getScreenId())){
            throw new AlreadyExistException("This is Show is Already Active");

        }
        return mapper.map(showRepository.save(show), ShowResponseDTO.class);
    }

    @Override
    public Show getShowById(Long id) {
        return null;
    }

    public ShowResponseDTO updateShow(ShowDTO showDTO) {
        Show show = mapper.map(showDTO, Show.class);

        return new ShowResponseDTO();
    }

    public List<ShowResponseDTO> getShowsByMovieName(String movieName) throws NotFoundException {
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

    public String deactivateShowById(Long id){
        String message = "Deleted Successfully";
        showRepository.deleteById(id);
        if (showRepository.existsById(id)){
            message = "Show is not Deleted";
        }
        return message;
    }

}
