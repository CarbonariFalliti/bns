package it.secretbasium.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.secretbasium.bns.dal.GiftDAO;
import it.secretbasium.bns.entities.Gift;


@Service
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
    public Gift addGift(Gift gift) {
        return repo.save(gift);
    }

    @Override
    public Gift updateGift(Gift gift) {
        return repo.save(gift);
    }

    @Override
    public void deleteGift(String id) {
        repo.deleteById(id);
    }

    @Override
    public List<Gift> findByGroupId(String groupId) {
        return repo.findByGroupId(groupId);
    }

    @Override
    public List<Gift> findByBasium(String basium) {
        return repo.findByBasiumId(basium);
    }

    @Override
    public List<Gift> findByBabbo(String babbo) {
        return repo.findByBabboId(babbo);
    }

}
    

