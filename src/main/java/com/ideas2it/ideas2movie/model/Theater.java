/**
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

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ideas2it.ideas2movie.model.Movie;

/**
 * <h1>
 *    Theater
 * <h1/>
 * <p>
 *    used to get and store the theater details in ideas2movie.
 * <p/>
 *
 *  @version 1.0
 *  @since 05-Jan-2023
 *  @author  Yogeshwar S
 */
@Entity
@Getter
@Setter
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String theaterName;
    @NotNull
    private String city;
    @NotNull
    private String area;
    @NotNull
    private String pincode;
    @ColumnDefault(value = "true")
    @Column( insertable = false)
    private boolean activeStatus;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
