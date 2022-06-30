package com.covid.api;

import com.covid.models.Person;
import com.covid.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id){
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @PostMapping("")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return ResponseEntity.ok().body(this.personService.createPerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person person){
        person.setId(id);
        return ResponseEntity.ok().body(this.personService.updatePerson(person));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePerson(@PathVariable String id){
        this.personService.deletePersonById(id);
        return HttpStatus.OK;
    }
}
