package it.secretbasium.bns.service;

import java.util.List;

import it.secretbasium.bns.entities.Gift;

public interface GiftService {
    List<Gift> getAllGifts(); 
    Gift getGiftById(String id);
    void addGift(Gift gift);
    void updateGift(Gift gift);
    void deleteGift(String id);
    
    
}
