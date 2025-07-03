package com.joaoeduardoam.unipds.events.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "conferences")
@Getter
@Setter
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    private String address;

//    @OneToMany(mappedBy = "conference")
//    private List<Session> sessions;



}
