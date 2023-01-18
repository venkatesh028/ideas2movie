package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Role;

/**
 * <h2>
 *     RoleRepository
 * </h2>
 * <p>
 *     RoleRepository provides the CRUD for the Role of the User by extending JPA Repository
 *     like Saving, and Fetching the Details of Role from the repository
 *     and Contains the Custom Method to check whether the Role is exist for the given Name
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
     *      Checks whether there is Role in the repository for the given Name or not
     *      and returns the boolean value accordingly
     * </p>
     *
     * @param name - Name of the Role to check If Exist or not
     * @return boolean - true If name is Exist else false
     */
    boolean existsByName(String name);
}
