package com.fernando.basic.modules.users.controllers;

import com.fernando.basic.modules.users.models.enttites.User;
import com.fernando.basic.modules.users.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id){
        User userDb = userRepository.findById(id).orElse(null);
        if (userDb == null){
            return ResponseEntity.badRequest().build();
        } else {
            userDb.setFirstname(user.getFirstname());
            userDb.setLastname(user.getLastname());
            userDb.setBirthdate(user.getBirthdate());
            return ResponseEntity.ok(userRepository.save(userDb));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            return ResponseEntity.badRequest().build();
        }else {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

}
