package it.secretbasium.bns.service;

import java.util.List;

import it.secretbasium.bns.entities.Group;
import it.secretbasium.bns.entities.Person;

public interface PersonService {
    List<Person> getAllPeople(); 
    Person getPersonById(String id);
    Person addPerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(String id);
    Person getPersonByName(String name);
    Person getPersonByEmail(String email);
    // List<Group> getGroups(String id);
}
