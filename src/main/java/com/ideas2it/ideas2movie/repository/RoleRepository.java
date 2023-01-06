package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(String name);
}
