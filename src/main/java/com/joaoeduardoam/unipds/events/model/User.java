package com.joaoeduardoam.unipds.events.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    private String email;

//    @ManyToMany(mappedBy = "users")
//    private List<Session> sessions;





}
