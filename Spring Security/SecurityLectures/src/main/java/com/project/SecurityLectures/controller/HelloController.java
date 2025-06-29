package com.project.SecurityLectures.controller;

import com.project.SecurityLectures.jwt.JwtUtils;
import com.project.SecurityLectures.requestResponse.LoginRequest;
import com.project.SecurityLectures.requestResponse.LoginResponse;
import com.project.SecurityLectures.service.SignInService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private SignInService signInService;

    @GetMapping("/hello")
    public String greet() {
        return "hello";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndpoint() {
        return "hello User";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "admin";
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(signInService.authenticateUser(loginRequest), HttpStatus.OK);
        /*
        Authentication authentication ;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            Map<String,Object> map = new HashMap<>();
            map.put("Message ","Bad Credentials");
            map.put("Status",false);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtils.generatingTokenFromUsername(userDetails);
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(item -> item.getAuthority())
                .toList();
        LoginResponse loginResponse = new com.project.SecurityLectures.requestResponse.LoginResponse(jwtToken,userDetails.getUsername(),roles);
        return  ResponseEntity.ok(loginResponse);
    }*/
    }
}