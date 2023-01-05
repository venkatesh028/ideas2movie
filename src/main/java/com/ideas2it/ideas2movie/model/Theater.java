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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theaterName;
    @ColumnDefault(value = "true")
    @Column( insertable = false)
    private boolean activeStatus;
    @CreationTimestamp
    private Timestamp createdOn;
    @UpdateTimestamp
    private Timestamp updatedOn;
    @OneToOne
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "id"
    )
    private TheaterAddress theaterAddress;
}
