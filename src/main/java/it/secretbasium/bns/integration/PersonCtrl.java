package it.secretbasium.bns.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.secretbasium.bns.entities.Person;
import it.secretbasium.bns.service.PersonService;

@RestController
public class PersonCtrl {
    
    @Autowired
    PersonService ps;


    @GetMapping("/person")
    public Person getPerson(@RequestParam(value = "id") String id) {
        return ps.getPersonById(id);
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return ps.getAllPeople();
    }

    @GetMapping("/people/name")
    public Person getPersonByName(@RequestParam(value = "name") String name) {
        return ps.getPersonByName(name);
    }
    @GetMapping("/people/email")
    public Person getPersonByEmail(@RequestParam(value = "email") String email) {
        return ps.getPersonByEmail(email);
    }
    @PostMapping("/person")
    public void addPerson(
        @RequestParam String email,
        @RequestParam String password
        
        
        ) {
        Person p = new Person();
        if (ps.getPersonByEmail(email) != null) {
            throw new IllegalArgumentException("Person with email " + email + " already exists");
        }
        p.setEmail(email);
        
        p.setPassword(password);
        ps.addPerson(p);
    }


    @PutMapping("/person")
    public void updatePerson(
    @RequestParam Person person) {
    
        ps.updatePerson(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestParam(value = "id") String id) {
        ps.deletePerson(id);
    }
    @PostMapping("/person-existence-in-group-check")
    public Person checkPersonExistsAndCreate(@RequestParam String email, @RequestParam String groupId) {
        Person p = ps.getPersonByEmail(email);
        if (p == null) {
            p = new Person();
            p.setEmail(email);
            ps.addPerson(p);

        }
        if (p.getGroupsId()==null)
            p.setGroupsId(new ArrayList<>());
        
        p.getGroupsId().add(groupId);
        return ps.updatePerson(p);
    }

}
