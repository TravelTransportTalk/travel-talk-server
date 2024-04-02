package com.itmo.traveltalk.controller;

import com.itmo.traveltalk.dto.AuthUserRequest;
import com.itmo.traveltalk.dto.ChangeUserRequest;
import com.itmo.traveltalk.dto.RegisterUserRequest;
import com.itmo.traveltalk.dto.UserControllerResp;
import com.itmo.traveltalk.entity.User;
import com.itmo.traveltalk.service.UserService;
import com.itmo.traveltalk.utils.GlobalConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(GlobalConstants.GLOBAL_API_PREFIX + "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserControllerResp> register(@RequestBody RegisterUserRequest request) {
        if (userService.findUserByTgId(request.getTgId()).isPresent()) {
            return new ResponseEntity<>(new UserControllerResp("User with this tg id already registered"), HttpStatus.CONFLICT);
        }

        User newUser = new User(request.getNick(),
                request.getFullName(),
                request.getDescription(),
                request.getTgUsername(),
                request.getTgId());

        return new ResponseEntity<>(
                new UserControllerResp(
                        "User is registered",
                        userService.save(newUser)),
                HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<UserControllerResp> auth(@RequestBody AuthUserRequest request) {

        Optional<User> user = userService.findUserByTgId(request.getTgId());
        return user.map(value -> new ResponseEntity<>(new UserControllerResp("User is found", value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new UserControllerResp("User with this tgId was not found"), HttpStatus.NOT_FOUND));

    }

    @PostMapping("/change")
    public ResponseEntity<UserControllerResp> changeUserInfo(@RequestBody ChangeUserRequest request) {
        Optional<User> userOptional = userService.findUserByTgId(request.getTgId());

        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(new UserControllerResp("User with this tgId was not found"), HttpStatus.NOT_FOUND);
        }

        User user = userOptional.get();

        if (isNotEmpty(request.getFullName())) {
            user.setFullName(request.getFullName());
        }

        if (isNotEmpty(request.getNick())) {
            user.setNick(request.getNick());
        }

        if (isNotEmpty(request.getDescription())) {
            user.setDescription(request.getDescription());
        }

        return new ResponseEntity<>(new UserControllerResp("User info was successfully updated", userService.save(user)), HttpStatus.OK);

    }

    private boolean isNotEmpty(String param) {
        return param != null && !param.isEmpty();
    }
}
