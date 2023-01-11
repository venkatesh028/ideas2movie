/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h1>
 *    Theater
 * <h1/>
 * <p>
 *    Entity of Theater
 * <p/>
 *
 *  @version 1.0
 *  @since 05-Jan-2023
 *  @author  Yogeshwar S
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "theater")
@Where(clause = "is_active = true")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = Message.THEATER_NAME_SHOULD_NOT_BE_EMPTY)
    private String theaterName;
    @NotBlank(message = Message.CITY_NAME_SHOULD_NOT_BE_EMPTY)
    private String city;
    @NotBlank(message = Message.AREA_NAME_SHOULD_NOT_BE_EMPTY)
    private String area;
    @ColumnDefault(value = "true")
    @Column( insertable = false)
    private boolean isActive;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
