package it.secretbasium.bns.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.secretbasium.bns.dal.GroupDAO;
import it.secretbasium.bns.entities.Group;
import it.secretbasium.bns.entities.Person;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupDAO repo;
    @Autowired
    PersonService ps;

    @Override
    public Group getGroupById(String id) {
        return repo.findById(id).get();
    }

    @Override
    public Group addGroup(Group group) {
        return repo.save(group);
    }

    @Override
    public Group updateGroup(Group group) {
        return repo.save(group);
    }

    @Override
    public void deleteGroup(String id) {
        repo.deleteById(id);
        
    }

    @Override
    public List<Person> getMembers(String id) { 
        Group group = repo.findById(id).get();
        List<Person> members = new ArrayList();
        for ( String  personId : group.getMembers()) {
            members.add( ps.getPersonById(personId));
        }
        return members;
    }
    
}
