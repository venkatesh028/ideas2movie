/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
 *     Screen
 * </h2>
 * <p>
 *     Entity of screen
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
@Table(name = "screen")
@Where(clause = "is_active = true")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @ColumnDefault(value = "true")
    @Column(insertable = false)
    private boolean isActive;
    @NotNull
    private int totalNumberOfRows;
    @NotNull
    private int totalNumberOfColumns;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "theate_id",
            referencedColumnName = "id"
    )
    private Theater theater;
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Show> shows;
}
