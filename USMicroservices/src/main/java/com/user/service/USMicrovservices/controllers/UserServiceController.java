package com.user.service.USMicrovservices.controllers;

import com.user.service.USMicrovservices.entities.User;
import com.user.service.USMicrovservices.exceptions.ResourceNotFoundException;
import com.user.service.USMicrovservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getALlUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) throws ResourceNotFoundException {
       User user = userService.getUserById(userId);
       return ResponseEntity.ok(user);
    }

    @PutMapping("/delete/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable String userId) throws ResourceNotFoundException {
        userService.deleteUserByID(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userId) throws ResourceNotFoundException {
        User updatedUser = userService.updateUser(user, userId);
        return ResponseEntity.ok(updatedUser);
    }

}
