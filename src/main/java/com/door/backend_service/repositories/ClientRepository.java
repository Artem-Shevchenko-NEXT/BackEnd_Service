package com.door.backend_service.repositories;

import com.door.backend_service.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Client entity.
 * Extends CrudRepository to provide basic CRUD operations (Create, Read, Update, Delete).
 * Spring Data JPA automatically implements this interface at runtime.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    /**
     * Find a client by phone number.
     * This is a custom query method - Spring Data JPA generates the implementation
     * based on the method name convention.
     *
     * @param phone the phone number to search for
     * @return Optional containing the client if found, empty otherwise
     */
    Optional<Client> findByPhone(String phone);
}

