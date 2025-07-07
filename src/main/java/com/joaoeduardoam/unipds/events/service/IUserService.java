package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.security.*;

import java.util.*;

public interface IUserService {

    public User addUser(User user);
    public User getUserById(Integer id);
    public User getUserByEmail(String email);
    public List<User> getAllUsers();
    public MyToken login(User user);

}
