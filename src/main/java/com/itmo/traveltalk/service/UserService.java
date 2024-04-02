package com.itmo.traveltalk.service;

import com.itmo.traveltalk.entity.User;
import com.itmo.traveltalk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    public Optional<User> findUserByTgId(Integer tgId) {
        return userRepository.findByTgId(tgId);
    }


}
