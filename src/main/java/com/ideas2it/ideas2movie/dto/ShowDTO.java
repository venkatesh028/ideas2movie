/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h2>
 *     ShowDTO
 * </h2>
 * <p>
 *     ShowDTO represents a Simplified version of the Show Model
 *     which Holds the Necessary Information of the Show model
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@Getter
@Setter
public class ShowDTO {
    @NotNull(message = Message.DATE_SHOULD_NOT_EMPTY)
    @FutureOrPresent(message = Message.ENTER_PRESENT_OR_FUTURE_DATE)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate screeningDate;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;
    @NotNull(message = Message.SCREEN_ID_SHOULD_NOT_EMPTY)
    private Long screenId;
    @NotNull(message = Message.MOVIE_ID_SHOULD_NOT_BE_EMPTY)
    private Long movieId;
    @NotNull(message = Message.PRICE_SHOULD_NOT_BE_NULL)
    @Min(10)
    private Double price;
}
