package it.secretbasium.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.secretbasium.bns.dal.PersonDAO;
import it.secretbasium.bns.entities.Person;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    PersonDAO repo;

    @Override
    public List<Person> getAllPeople() {
        
        return repo.findAll();
    }

    @Override
    public Person getPersonById(String id) {    
        return repo.findById(id).get();
    }

    @Override
    public Person addPerson(Person person) {
        return repo.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return repo.save(person);
    }

    @Override
    public void deletePerson(String id) {
        repo.deleteById(id);
    }

    @Override
    public Person getPersonByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return repo.findByEmail(email);
       
    }
    
}
