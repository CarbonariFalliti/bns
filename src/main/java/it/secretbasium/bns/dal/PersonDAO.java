package it.secretbasium.bns.dal;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.secretbasium.bns.entities.Person;

public interface PersonDAO extends MongoRepository<Person, String> {

    Person findByName(String name);
    Person findByEmail(String email);
}
    

