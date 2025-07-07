package com.joaoeduardoam.unipds.events.security;


import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.service.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final String LOGIN_SUCCESSFULLY_MESSAGE = "Login success!!";

//    private final AuthenticationManager manager;

    private final IUserService service;


    @PostMapping
    public ResponseEntity effectuateLogin(@RequestBody @Valid User user) {

        try{
//            var authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
//            var authentication = manager.authenticate(authenticationToken);
//
//            var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
            System.out.println(service.login(user));
            return ResponseEntity.ok(service.login(user));




        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

}
