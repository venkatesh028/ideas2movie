package com.ideas2it.ideas2movie.service;

public interface TheaterService {
    /**
     * <p>
     * To create Theater Details
     * </p>
     *
     * @param theaterDto it contains details of the theater.
     * @return TheaterDto
     */
    TheaterResponseDTO createTheater(TheaterDTO theaterDto)
            throws NotFoundException;

    /**
     * <p>
     * To List the all Theater Details based on particular movie.
     * </p>
     *
     * @return List<TheaterDto> it contains list of theater  based on particular movie.
     */
    List<TheaterDto> getAllTheaterByMovieId(TheaterDTO theaterDto,
            MovieDto movieDto) throws NotFoundException;

    /**
     * <p>
     * T0 List all the Theater Names which is currently running.
     * </p>
     *
     * @return List<TheaterDto>
     */
    List<TheaterDto> getAllTheater(TheaterDTO theaterDto)
            throws NotFoundException;

    /**
     * <p>
     * To get the Theater Details based on theater id.
     * </p>
     *
     * @param theaterId it contains theater id
     * @return TheaterDto
     */
    TheaterDto getTheaterById(TheaterDTO theaterDto)
            throws NotFoundException;

    /**
     * <p>
     * To update the Theater Details
     * </p>
     *
     * @param theaterDto it contains theater details
     * @return List<TheaterDto>
     */
    TheaterDto updateTheater(TheaterDto theaterDto )
            throws NotFoundException;
}