package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.exception.*;
import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;


    @Override
    public User addUser(User user) {
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


}
