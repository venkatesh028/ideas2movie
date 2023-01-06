package com.ideas2it.ideas2movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {
    boolean existsScreenByNameAndTheaterId(String screenName, Long theaterId);

}
