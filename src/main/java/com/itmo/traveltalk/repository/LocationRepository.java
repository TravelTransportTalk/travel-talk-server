package com.itmo.traveltalk.repository;

import com.itmo.traveltalk.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {

    Optional<Location> findById(UUID id);

    Optional<Location> findByName(String name);
}
