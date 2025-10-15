package com.door.backend_service.services;

import com.door.backend_service.dtos.ClientDto;
import com.door.backend_service.dtos.CreateClientRequest;
import com.door.backend_service.entities.Client;
import com.door.backend_service.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for Client business logic.
 * The service layer sits between the controller and repository layers.
 * It handles business logic, data transformation, and orchestrates repository calls.
 * Using a service layer keeps controllers thin and promotes code reusability.
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    /**
     * Constructor injection of dependencies.
     * Spring automatically injects the ClientRepository bean.
     * Constructor injection is preferred as it makes dependencies explicit and enables immutability.
     */
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Retrieve all clients from the database.
     *
     * @return List of ClientDto objects
     */
    public List<ClientDto> getAllClients() {
        List<ClientDto> clientDtos = new ArrayList<>();

        // Fetch all clients from repository
        Iterable<Client> clients = clientRepository.findAll();

        // Convert each Client entity to ClientDto
        for (Client client : clients) {
            clientDtos.add(mapToDto(client));
        }

        return clientDtos;
    }

    /**
     * Retrieve a single client by ID.
     *
     * @param id the client ID
     * @return ClientDto if found
     * @throws RuntimeException if client not found
     */
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        return mapToDto(client);
    }

    /**
     * Create a new client.
     *
     * @param request the creation request containing client data
     * @return the created ClientDto
     */
    public ClientDto createClient(CreateClientRequest request) {
        // Create new Client entity from request data
        Client client = new Client();
        client.setClientName(request.getClientName());
        client.setPhone(request.getPhone());
        client.setCases(request.getCases());

        // Save to database - the @PrePersist method will set createdDate automatically
        Client savedClient = clientRepository.save(client);

        // Convert and return as DTO
        return mapToDto(savedClient);
    }

    /**
     * Delete a client by ID.
     *
     * @param id the client ID to delete
     */
    public void deleteClient(Long id) {
        // Verify client exists before deleting
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found with id: " + id);
        }

        clientRepository.deleteById(id);
    }

    /**
     * Helper method to map Client entity to ClientDto.
     * This encapsulates the conversion logic in one place.
     *
     * @param client the Client entity
     * @return the corresponding ClientDto
     */
    private ClientDto mapToDto(Client client) {
        return new ClientDto(
                client.getClientId(),
                client.getClientName(),
                client.getPhone(),
                client.getCases(),
                client.getCreatedDate()
        );
    }
}

