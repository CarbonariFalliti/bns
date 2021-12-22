package it.secretbasium.bns.dal;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.secretbasium.bns.entities.Group;

public interface GroupDAO extends  MongoRepository<Group, String> {
    
    List<Group> findByName(String name);
    List<Group> findByMembers(String member);
    
    
}
    

