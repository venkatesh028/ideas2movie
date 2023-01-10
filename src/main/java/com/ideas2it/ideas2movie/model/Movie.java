/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import java.sql.Timestamp;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

/**
 * <h1>
 *    Movie
 * <h1/>
 * <p>
 *    used to get and store the movie details in ideas2movie.
 * <p/>
 *
 *  @version 1.0
 *  @since 05-Jan-2023
 *  @author  Yogeshwar S
 */
@Entity
@Getter
@Setter
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Language language;
    @NotNull
    private LocalTime duration;
    @NotNull
    private Genre genre;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "castAndCrew_id",
            referencedColumnName = "id"
    )
    private CastAndCrew castAndCrew;
}