package com.joaoeduardoam.unipds.events.repository;

import com.joaoeduardoam.unipds.events.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

}
