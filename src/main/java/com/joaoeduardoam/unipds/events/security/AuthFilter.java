package com.joaoeduardoam.unipds.events.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.web.filter.*;

import java.io.*;

public class AuthFilter extends OncePerRequestFilter {

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

            System.out.println(request.getRequestURL()+" Passou pelo filtro");

            if (request.getHeader("Authorization") != null) {
                Authentication auth = TokenUtil.decode(request);
                if (auth != null) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }

            filterChain.doFilter(request, response); // estou apenas encaminhando a requisição como ela é

        }

}
