package com.door.backend_service.repositories;

import com.door.backend_service.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {


    Optional<Client> findByPhone(String phone);
}

