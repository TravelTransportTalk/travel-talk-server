package com.itmo.traveltalk.repository;

import com.itmo.traveltalk.entity.Location;
import com.itmo.traveltalk.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransportRepository extends JpaRepository<Transport, UUID> {

    Optional<Transport> findById(UUID id);

    Optional<Transport> findByName(String name);
}
