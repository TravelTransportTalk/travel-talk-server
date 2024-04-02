package com.itmo.traveltalk.repository;

import java.util.List;

import com.itmo.traveltalk.entity.RawStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<RawStation, String> {

    List<RawStation> findByTransportType(String transportType);
}
