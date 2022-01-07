package it.secretbasium.bns.service;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.secretbasium.bns.dal.VoteDAO;
import it.secretbasium.bns.entities.Vote;

@Service
public class VoteServiceImpl implements VoteService {
    
    @Autowired
    VoteDAO repo;
    
    @Override
    public Vote createVote(Vote newVote) {
        return repo.save(newVote);
    }

    @Override
    public Vote findVoteByPersonIdAndGiftId(String personId, String giftId) {
        return repo.findByPersonIdAndGiftId(personId, giftId);
        
    }

}
    

