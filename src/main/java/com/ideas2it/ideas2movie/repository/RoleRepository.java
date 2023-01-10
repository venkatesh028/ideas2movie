package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>
 *     RoleRepository
 * </h1>
 * <p>
 *     Repository of the Role
 *     to Save and Fetch the Role for User
 *     by using JPA Repository
 * </p>
 *
 * @author - AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * <h1>
     *      existsByName
     * </h1>
     * <p>
     *      Checks and Returns the result
     *      for Name is Already Exist or Not
     * </p>
     *
     * @param name - Name to check Is Exist
     * @return isExist - Holds the response of isExist
     */
    boolean existsByName(String name);
}
