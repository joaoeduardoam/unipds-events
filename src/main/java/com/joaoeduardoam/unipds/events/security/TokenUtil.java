package com.joaoeduardoam.unipds.events.security;

import com.joaoeduardoam.unipds.events.model.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.web.filter.*;

//import io.jsonwebtoken.security.Keys;

import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.util.*;

public class TokenUtil {

    public static final String EMISSOR = "ProfessorIsidro";
    public static final long EXPIRATION = 15 * 1000; // in ml, 1000 = 1s
    public static final String SECRET_KEY = "0123456789012345678901234567890123456789";


    public static MyToken encode(User user) {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            String jwtToken = Jwts.builder().subject(user.getEmail())
                    .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                    .issuer(EMISSOR)
                    .signWith(key)
                    .compact();
            return new MyToken(jwtToken);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Authentication decode(HttpServletRequest request) {
        try {
            String header = request.getHeader("Authorization");
            System.out.println("Request header: " + header);
            if (header != null) {
                String token = header.replace("Bearer ", "");
                SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
                JwtParser parser = Jwts.parser().verifyWith(key).build();
                Claims claims = (Claims)parser.parse(token).getPayload();

                String subject = claims.getSubject();
                String issuer = claims.getIssuer();
                Date   exp    = claims.getExpiration();

                if (issuer.equals(EMISSOR) && subject.length() > 0 && exp.after(new Date(System.currentTimeMillis())))
                    return new UsernamePasswordAuthenticationToken("valido", null, Collections.emptyList());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
