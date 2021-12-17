package it.secretbasium.bns.dal;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.secretbasium.bns.entities.Gift;

public interface GiftDAO extends MongoRepository<Gift, String> {


}
