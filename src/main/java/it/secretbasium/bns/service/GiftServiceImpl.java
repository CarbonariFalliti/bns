package it.secretbasium.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.secretbasium.bns.dal.GiftDAO;
import it.secretbasium.bns.entities.Gift;

public class GiftServiceImpl implements GiftService {
    @Autowired
    private GiftDAO repo;


    @Override
    public List<Gift> getAllGifts() {
        return repo.findAll();
    }

    @Override
    public Gift getGiftById(String id) {
        return repo.findById(id).get();
    }

    @Override
    public void addGift(Gift gift) {
        repo.save(gift);
    }

    @Override
    public void updateGift(Gift gift) {
        repo.save(gift);
    }

    @Override
    public void deleteGift(String id) {
        repo.deleteById(id);
    }

}
    

