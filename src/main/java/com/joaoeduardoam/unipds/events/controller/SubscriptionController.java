package com.joaoeduardoam.unipds.events.controller;

import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final ISubscriptionService service;

    @PostMapping
    public ResponseEntity<Subscription> addSubscriptin(@RequestBody Subscription subscription){
        System.out.println("DEBUG = "+subscription);
        return ResponseEntity.status(201).body(service.addSubscription(subscription));
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<List<Subscription>> getByUser(@PathVariable Integer id){
        User user = new User();
        user.setUserId(id); //Give up using repository.findByID as it is more efficient and, in the current case (filter by ID), sufficient
        return ResponseEntity.ok(service.getAllByUser(user));
    }

    @GetMapping("/session/{id}")
    public ResponseEntity<List<Subscription>> getBySession(@PathVariable Integer id){
        Session session = new Session();
        session.setId(id);
        return ResponseEntity.ok(service.getAllBySession(session));
    }

}
