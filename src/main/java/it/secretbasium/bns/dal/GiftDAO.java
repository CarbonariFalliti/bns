package it.secretbasium.bns.dal;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.secretbasium.bns.entities.Gift;

public interface GiftDAO extends MongoRepository<Gift, String> {

    List<Gift> findByGroupId(String id);
    List<Gift> findByBasiumId(String basiumId);
    List<Gift> findByBabboId(String babboId);

}
