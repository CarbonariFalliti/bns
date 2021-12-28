package it.secretbasium.bns.service;

import java.util.List;

import it.secretbasium.bns.entities.Group;
import it.secretbasium.bns.entities.Person;

public interface GroupService {
    Group getGroupById(String id);
    Group addGroup(Group group);
    Group updateGroup(Group group);
    void deleteGroup(String id);
    List<Person> getMembers(String id);
    List<Group> search(String name);
    
}
