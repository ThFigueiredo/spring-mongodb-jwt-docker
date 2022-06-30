package com.covid.service;

;
import com.covid.config.ResourceNotFoundException;
import com.covid.models.Person;
import com.covid.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;




@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }


    @Override
    public Person updatePerson(Person person) {
        Optional<Person> personDb = this.personRepository.findById(person.getId());

        if(personDb.isPresent()) {
            Person personUpdate = personDb.get();
            personUpdate.setId(person.getId());
            personUpdate.setName(person.getName());
            personRepository.save(personUpdate);
            return personUpdate;
        }else {
            throw new ResourceNotFoundException("Person not found with id : " + person.getId());
        }
    }


    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }


    @Override
    public Person getPersonById(String personId) {
        Optional<Person> personDb = this.personRepository.findById(personId);

        if(personDb.isPresent()) {
            return personDb.get();
        }else {
            throw new ResourceNotFoundException("Person not found with id : " + personId);
        }
    }

    @Override
    public void deletePersonById(String personId) {
        Optional<Person> personDb = this.personRepository.findById(personId);

        if(personDb.isPresent()) {
            this.personRepository.delete(personDb.get());
        }else {
            throw new ResourceNotFoundException("Person not found with id : " + personId);
        }

    }

}




