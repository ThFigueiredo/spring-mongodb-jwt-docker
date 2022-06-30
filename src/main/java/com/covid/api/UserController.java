package com.covid.api;

import com.covid.models.User;
import com.covid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService personService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(personService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        return ResponseEntity.ok().body(personService.getUserById(id));
    }

//    @PostMapping("")
//    public ResponseEntity<User> createUser(@RequestBody User person){
//        return ResponseEntity.ok().body(this.personService.createUser(person));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User person){
        person.setId(id);
        return ResponseEntity.ok().body(this.personService.updateUser(person));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable String id){
        this.personService.deleteUserById(id);
        return HttpStatus.OK;
    }
}
