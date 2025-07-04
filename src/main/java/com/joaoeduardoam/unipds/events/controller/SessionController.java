package com.joaoeduardoam.unipds.events.controller;

import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions")
public class SessionController {

    private final ISessionService service;

    @PostMapping
    public ResponseEntity<Session> addSession(@RequestBody Session session){
        return ResponseEntity.status(201).body(service.addSession(session));
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions(){
        return ResponseEntity.ok(service.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getSessionById(id));
    }

}
