package it.secretbasium.bns.service;

import java.util.List;

import it.secretbasium.bns.entities.Gift;

public interface GiftService {
    List<Gift> getAllGifts(); 
    Gift getGiftById(String id);
    Gift addGift(Gift gift);
    Gift updateGift(Gift gift);
    void deleteGift(String id);
    List<Gift> findByGroupId(String groupId);
    List<Gift> findByBasium(String basium);
    List<Gift> findByBabbo(String babbo);
    
    
}
