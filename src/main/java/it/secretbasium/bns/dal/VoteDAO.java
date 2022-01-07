package it.secretbasium.bns.dal;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.secretbasium.bns.entities.Vote;

public interface VoteDAO extends MongoRepository<Vote, String> {

    Vote findByPersonIdAndGiftId(String personId, String giftId);

}
    

