/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

/**
 * <h2>
 *     Show
 * </h2>
 * <p>
 *     Entity of show
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 05/01/2022
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "`show`")
@Where(clause = "is_active = true")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate screeningDate;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
    @NotNull
    private Double price;
    @ColumnDefault(value = "true")
    @Column(insertable = false)
    private boolean isActive;
    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "screen_id",
            referencedColumnName = "id"
    )
    private Screen screen;
    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "movie_id",
            referencedColumnName = "id"
    )
    private Movie movie;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
