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

    @PutMapping("/full-person")
    public void updatePerson(
        @RequestParam Person p
        ) {
        ps.updatePerson(p);
    }

    @PutMapping("/person")
    public void updatePerson(
    @RequestParam String id,
    @RequestParam String email,
    @RequestParam String password,
    @RequestParam String name,
    @RequestParam(required = false) String[] groupsId) {
        Person p = ps.getPersonById(id);
        if (p == null) {
            throw new IllegalArgumentException("Person with id " + id + " doesn't exist");
        }
        p.setEmail(email);
        p.setPassword(password);
        p.setName(name);
        if (groupsId != null) {
            List<String> groups = new ArrayList<>();
            for (String groupId : groupsId) {
                groups.add(groupId);
            }
            p.setGroupsId(groups);
        }
        
        ps.updatePerson(p);
        
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
            p.setActivated(false);
            ps.addPerson(p);

        }
        if (p.getGroupsId()==null)
            p.setGroupsId(new ArrayList<>());
        
        p.getGroupsId().add(groupId);
        return ps.updatePerson(p);
    }
   

}
