package com.itmo.traveltalk.repository;

import com.itmo.traveltalk.entity.Trip;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID>, JpaSpecificationExecutor<Trip> {

    List<Trip> findAll(Specification<Trip> specification);
}
