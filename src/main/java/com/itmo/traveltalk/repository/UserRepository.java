package com.itmo.traveltalk.repository;

import com.itmo.traveltalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {


    Optional<User> findById(UUID userId);
    Optional<User> findByTgId(Integer tgId);

}

