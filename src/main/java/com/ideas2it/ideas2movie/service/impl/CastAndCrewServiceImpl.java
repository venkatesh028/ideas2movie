/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.CastAndCrew;
import com.ideas2it.ideas2movie.dto.CastAndCrewDTO;
import com.ideas2it.ideas2movie.dto.responsedto.CastAndCrewResponseDTO;
import com.ideas2it.ideas2movie.service.CastAndCrewService;
import com.ideas2it.ideas2movie.repository.CastAndCrewRepository;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h1>
 *     CastAndCrewServiceImpl
 * </h1>
 * <p>
 *     To add the cast and crew details for movie and
 *     returns the response accordingly
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class CastAndCrewServiceImpl implements CastAndCrewService {
    private final CastAndCrewRepository castAndCrewRepository;
    ModelMapper modelMapper = new ModelMapper();

    /**
     * <h1>
     *     CastAndCrew ServiceImpl Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for CastAndCrew Repository.
     * </p>
     *
     * @param castAndCrewRepository - reference variable for CastAndCrew Repository
     */
    public CastAndCrewServiceImpl(CastAndCrewRepository castAndCrewRepository) {
        this.castAndCrewRepository = castAndCrewRepository;
    }
    @Override
    public CastAndCrewResponseDTO addCastAndCrew(CastAndCrewDTO castAndCrewDTO) {
        CastAndCrew castAndCrew = modelMapper.map(castAndCrewDTO, CastAndCrew.class);
        return modelMapper.map(castAndCrewRepository.save(castAndCrew),
                CastAndCrewResponseDTO.class);
    }

    @Override
    public CastAndCrewResponseDTO getCastAndCrewById(Long id) throws NotFoundException {
        Optional<CastAndCrew> castAndCrew = castAndCrewRepository.findById(id);

        if (castAndCrew.isPresent()) {
            return modelMapper.map(castAndCrew.get(), CastAndCrewResponseDTO.class);
        }
        throw new NotFoundException(Message.CAST_AND_CREW_NOT_FOUND);
    }

    @Override
    public CastAndCrewResponseDTO updateCastAndCrew(Long id,
                   CastAndCrewDTO castAndCrewDTO) throws NotFoundException {
        CastAndCrew castAndCrew = modelMapper.map(castAndCrewDTO, CastAndCrew.class);
        castAndCrew.setId(id);
        Optional<CastAndCrew> existingCastAndCrew = castAndCrewRepository.findById(id);

        if (existingCastAndCrew.isPresent()) {
            return modelMapper.map(castAndCrewRepository.save(castAndCrew),
                    CastAndCrewResponseDTO.class);
        }
        throw new NotFoundException(Message.FAILED_TO_UPDATE);
    }

    @Override
    public String deleteCastAndCrew(Long id) throws NotFoundException {

        Optional<CastAndCrew> existingCastAndCrew = castAndCrewRepository
                .findById(id);

        if (existingCastAndCrew.isPresent()) {
            castAndCrewRepository.deleteById(id);
            existingCastAndCrew = castAndCrewRepository.findById(id);
            if (!existingCastAndCrew.isPresent()) {
                return Message.DELETED_SUCCESSFULLY;
            }
        }
        throw new NotFoundException(Message.FAILED_TO_DELETE);
    }
}
