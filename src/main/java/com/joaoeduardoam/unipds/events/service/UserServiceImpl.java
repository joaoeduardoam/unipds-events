package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.exception.*;
import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.repository.*;
import com.joaoeduardoam.unipds.events.security.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;


    @Override
    public User addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User "+id+" not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("Email "+email+" not registered"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public MyToken login(User user) {
        User storedUser = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new NotFoundException("Usuario nao encontrado!"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(user.getPassword(), storedUser.getPassword())) {
            return TokenUtil.encode(storedUser);
        }
        throw new RuntimeException("Unauthorized user");

    }


}
