package com.covid.service;

import com.covid.models.Person;


import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(String personId);
    void deletePersonById(String personId);
}

