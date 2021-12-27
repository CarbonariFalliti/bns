package it.secretbasium.bns.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gifts")
public class Gift {
    @JsonIgnore
    @Id
    private String id;
    private String name;
    private byte review;
    private String babboId;
    private String basiumId;
    private String groupId;
    private LocalDate date;
    
    public String getId() {
        return id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public byte getReview() {
        return review;
    }
    public void setReview(byte review) {
        this.review = review;
    }
    public String getBabboId() {
        return babboId;
    }
    public void setBabboId(String babboId) {
        this.babboId = babboId;
    }
    public String getBasiumId() {
        return basiumId;
    }
    public void setBasiumId(String basiumId) {
        this.basiumId = basiumId;
    }

    




}
