/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;


public interface ScreenService {

    ScreenResponseDTO createScreen(ScreenDTO screenDTO) throws NotFoundException;
    ScreenResponseDTO updateScreen(Long id, ScreenDTO screenDTO) throws AlreadyExistException, NotFoundException;
    String deleteScreen(Long id) throws NotFoundException;

}
