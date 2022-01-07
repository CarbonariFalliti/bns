package it.secretbasium.bns.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.secretbasium.bns.entities.Vote;
import it.secretbasium.bns.service.GiftService;
import it.secretbasium.bns.service.PersonService;
import it.secretbasium.bns.service.VoteService;

@RestController
public class VoteCtrl {
    @Autowired
    private VoteService voteService;
    
    @Autowired
    private PersonService personService;
    
    @Autowired
    private GiftService giftService;

    @PostMapping("/vote")
    public Vote createVote(
        @RequestParam(value = "personId") String personId,
        @RequestParam(value = "giftId") String giftId,
        @RequestParam(value = "rating") byte rating
    ) throws Exception {
        Vote newVote = new Vote();
        if ((personId != null)&&(personService.getPersonById(personId) != null)) {
            newVote.setPersonId(personId);
        } else {
           throw new Exception("Person not found");
        }
        if ((giftId != null)&&(giftService.getGiftById(giftId) != null)) {
            newVote.setGiftId(giftId);
        } else {
           throw new Exception("Gift not found");
        }
        if ( voteService.findVoteByPersonIdAndGiftId(personId, giftId) == null) {
            newVote.setRating(rating);
            System.out.println("Vote created");
            return voteService.createVote(newVote);
        } else {
            throw new Exception("Vote already exists");
        }
            
        }
        
    
    
}
