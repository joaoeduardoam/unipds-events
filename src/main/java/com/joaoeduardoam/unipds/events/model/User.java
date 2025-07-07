package com.joaoeduardoam.unipds.events.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;



//    @ManyToMany(mappedBy = "users")
//    private List<Session> sessions;





}
