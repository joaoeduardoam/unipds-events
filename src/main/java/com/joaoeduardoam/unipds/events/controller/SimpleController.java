package com.joaoeduardoam.unipds.events.controller;

import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SimpleController {


    @GetMapping("/open")
    public String sayHelloOpen() {
        return "Hello world from open endpoint";
    }

    @GetMapping("/restricted")
    public String sayHelloRestricted() {
        return "Hello world from restricted endpoint";
    }

}
