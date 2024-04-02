package com.itmo.traveltalk.service;

import com.itmo.traveltalk.entity.Transport;
import com.itmo.traveltalk.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransportService {

    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public Optional<Transport> findById(UUID id) {
        return transportRepository.findById(id);
    }

    public Transport save(Transport transport) {
        return transportRepository.saveAndFlush(transport);
    }

    public List<Transport> getAll() {
        return transportRepository.findAll();
    }

    public Optional<Transport> findByName(String name) {
        return transportRepository.findByName(name);
    }
}
