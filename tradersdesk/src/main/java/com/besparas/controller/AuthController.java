package com.besparas.controller;

import com.besparas.modal.User;
import com.besparas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

// The endpoint for the controller to start is the /auth route
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User user) throws Exception {



        //Check first if the email of the user exists or not
        User isEmailExists = userRepository.findByEmail(user.getEmail());

        if(isEmailExists != null){
            throw new Exception("email is already in use. The user exists.");
        }

        User newUser = new User() ;
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());

        // Now create the authentication controls for the saved user
        User savedUser = userRepository.save(newUser);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
                );

        SecurityContextHolder.getContext().setAuthentication(auth);

        // Passed the created because here we will create a new user
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

}
