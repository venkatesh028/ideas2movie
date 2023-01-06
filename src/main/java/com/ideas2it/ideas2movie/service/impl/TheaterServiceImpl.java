package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.model.Theater;
import com.ideas2it.ideas2movie.service.MovieService;
import com.ideas2it.ideas2movie.service.TheaterService;

public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theatreRepository;
    private final MovieService movieService;
    private final Mapper mapper;

    public TheaterServiceImpl(TheaterRepository theatreRepository,
                              MovieService movieService, Mapper mapper) {
        this.theaterRepository = theaterRepository;
        this.movieService = movieService;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TheaterResponseDTO createTheater(TheaterDTO theaterDto)
            throws NotFoundException {
        Theater theater = mapper.theaterDtoToTheater(theaterDto);
        if (theaterRepository.existsByTheaterName(theaterDto.getTheaterName())
           && theaterRepository.existsByTheaterCity(theaterDto.getTheaterCity())) {
            throw new AlreadyExistException("This Theatre is already exist");
        }
        return mapper.theaterToTheaterResponseDto(theaterRepository.save(theater));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TheaterDto> getAllTheater()
            throws NotFoundException {
        List <Theater> theaters = theaterRepository.findAllByActiveStatus(true);

        if (theaters.isEmpty()) {
            throw new NotFoundException("Oops No theater Details is exist!!");
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TheaterDto getTheaterById(TheaterDTO theaterDto)
            throws NotFoundException {
        Long id = theaterDto.getId();
        if (theaterRepository.existsById(theaterDto)) {
            Theater theater = theaterRepository.findByTheaterId(theaterDto);
            return mapper.theaterToTheaterDto(theater);
        }
        throw new NotFoundException("Oops No theater Details is exist on a given id!!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TheaterDto updateTheater(TheaterDto theaterDto)
            throws NotFoundException {

        if (null == theaterDto) {
            throw new NotFoundException("No theater exist  on given id");
        }
        return mapper.theaterToTheaterDto(theaterRepository
                .save(mapper.theaterDtoToTheatre(theaterDto)));
    }
}
