package it.secretbasium.bns.integration;


import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.secretbasium.bns.entities.Gift;
import it.secretbasium.bns.service.GiftService;
import it.secretbasium.bns.service.PersonService;

@RestController
public class GiftCtrl {
    @Autowired
    PersonService ps;

    @Autowired
    GiftService gs;

    @GetMapping("/newgift")
    public String pingPong(Model m) {
        return "pong";
    }
    @GetMapping("/gift")
    public Gift getGift(@RequestParam(value = "id") String id) {
        return gs.getGiftById(id);
    }


    @GetMapping("/gifts")
    public Iterable<Gift> getGifts() {
        return gs.getAllGifts();
    }


    // new gift
    @PostMapping("/gift")
    public Gift newGift(
        @RequestParam String name,
        @RequestParam String review,

        @RequestParam String babbo,
        @RequestParam String basiumId,
        @RequestParam(required = false) String groupId,
        @RequestParam(required = false) Date date 
    
        ) {
        Gift g = new Gift();
        g.setName(name);
        g.setReview(Byte.parseByte(review));
        
        g.setBabboId(babbo);
        g.setBasiumId(basiumId);
        g.setGroupId(groupId);
        // g.setDate(Date);
        System.out.println("new gift: " + g);
        return gs.addGift(g);
    
    }
    // update gift
    @PutMapping("/gift")
    public Gift updateGift(
        @RequestParam String id,
        @RequestParam String name,
        @RequestParam String review,

        @RequestParam String babbo,
        @RequestParam String basiumId
        ) {
        Gift g = gs.getGiftById(id);
        g.setName(name);
        g.setReview(Byte.parseByte(review));
        g.setBabboId(ps.getPersonByName(babbo).getId());
        g.setBasiumId(basiumId);
        System.out.println("update gift: " + g);
        return gs.updateGift(g);
    
    }

    // delete gift
    @DeleteMapping("/gift")
    public void deleteGift(
        @RequestParam String id
        ) {
        gs.deleteGift(id);
    }
    @GetMapping("/gifts/group")
    public Iterable<Gift> getGiftsByGroup(
        @RequestParam String groupId
        ) {
        return gs.findByGroupId(groupId);
    }
    @GetMapping("/gifts/basium")
    public Iterable<Gift> getGiftsByBasium(
        @RequestParam String basium
        ) {
        return gs.findByBasium(basium);
    }
    @GetMapping("/gifts/babbo")
    public Iterable<Gift> getGiftsByBabbo(
        @RequestParam String babbo
        ) {
        return gs.findByBabbo(babbo);
    }
}
