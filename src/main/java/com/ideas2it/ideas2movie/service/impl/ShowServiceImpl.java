package com.ideas2it.ideas2movie.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {
    private final ModelMapper mapper = new ModelMapper();

    public Show createShow(ShowDTO showDTO){
        Show show = mapper.map(showDTO, Show.class);

        return show;
    }
}
