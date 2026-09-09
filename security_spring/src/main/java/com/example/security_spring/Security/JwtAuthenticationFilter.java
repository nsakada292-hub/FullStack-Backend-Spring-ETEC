package com.example.security_spring.Security;

//import com.example.spring.security.service.CustomUserDetailsService;
import com.example.security_spring.Service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {


        String authHeader = request.getHeader("Authorization");


        // Check token exists
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }


        // Remove "Bearer "
        String token = authHeader.substring(7);


        // Extract email from JWT
        String email = jwtService.extractEmail(token);


        // Check user is not already authenticated
        if (email != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {


            UserDetails userDetails =
                    customUserDetailsService.loadUserByUsername(email);


            // Validate token
            if (jwtService.isTokenValid(token, userDetails)) {


                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );


                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );


                SecurityContextHolder.getContext()
                        .setAuthentication(authenticationToken);
            }
        }


        filterChain.doFilter(request, response);
    }
}
