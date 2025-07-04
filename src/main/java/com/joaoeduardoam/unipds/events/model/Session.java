package com.joaoeduardoam.unipds.events.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@ToString
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    
    private LocalDate startDate;

    private LocalTime startTime;

    @ManyToOne
    @JoinColumn(name = "conference_id") // Cria uma coluna na tabela "session" com o nome "conference_id"
    private Conference conference;



//
//    @ManyToMany
//    @JoinTable(
//            name = "subscriptions",
//            joinColumns = @JoinColumn(name = "session_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> users;




}
