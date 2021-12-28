package it.secretbasium.bns.dal;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import it.secretbasium.bns.entities.Group;

public interface GroupDAO extends  MongoRepository<Group, String> {
    
    List<Group> findByName(String name);
    List<Group> findByMembers(String member);
  

    @Query("{name: {$regex: ?0}}")
    List<Group> findByNameContaining(String name);
    
    
}
    

