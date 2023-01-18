/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Movie;

/**
 * <h1>
 *     MovieRepository
 * <h1/>
 * <p>
 *     Repository of the Movie
 *     to save, and fetch the Details of the Movie
 *     by using the JPA Repository
 * </p>
 *
 * @author  YOGESHWAR S
 * @version 1.0
 * @since   10.01.2023
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

 /**
  * <h1>
  *     findByName
  * </h1>
  * <p>
  *     Fetches the Details of the Movie
  *     by using the Movie Name
  * </p>
  *
  * @param name - Name of the Movie to fetch the Movie Details
  * @return movie - Details of the movie
  */
 Optional<Movie> findByName(String name);

 /**
  * <h1>
  *     findById
  * </h1>
  * <p>
  *     Fetches the Details of the Movie
  *     by using the Movie ID
  * </p>
  *
  * @param id - ID of the Movie to fetch the Movie Details
  * @return movie - Details of the movie
  */
 Optional<Movie> findById(Long id);

 /**
  * <h1>
  *     existById
  * </h1>
  * <p>
  *     Check the Details of the Movie exist in
  *     ideas2movie by using the ID of a movie
  * </p>
  *
  * @param id - ID of the Movie to fetch the Movie Details
  * @return boolean - If movie details exist return true or else false
  */
 boolean existsById(Long id);
}
