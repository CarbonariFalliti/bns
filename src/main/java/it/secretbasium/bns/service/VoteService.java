package it.secretbasium.bns.service;

import it.secretbasium.bns.entities.Vote;


public interface VoteService {

    Vote createVote(Vote newVote);

    Vote findVoteByPersonIdAndGiftId(String personId, String giftId);

}
