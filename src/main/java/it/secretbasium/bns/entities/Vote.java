package it.secretbasium.bns.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="votes")
public class Vote {
    private String id;
    private String personId;
    private String giftId;
    private byte rating;
    
    
    
    public String getGiftId() {
        return giftId;
    }
    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPersonId() {
        return personId;
    }
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public byte getRating() {
        return rating;
    }
    public void setRating(byte rating) {
        this.rating = rating;
    }   

}
