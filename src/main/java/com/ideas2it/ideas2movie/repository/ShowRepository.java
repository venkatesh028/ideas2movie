package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
