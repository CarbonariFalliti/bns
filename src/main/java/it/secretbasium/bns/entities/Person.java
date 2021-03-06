package it.secretbasium.bns.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="people")
public class Person {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private boolean isActivated;
    private List<String> groupsId;
    
    public List<String> getGroupsId() {
        return groupsId;
    }
    public boolean isActivated() {
        return isActivated;
    }
    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }
    public void setGroupsId(List<String> groupsId) {
        this.groupsId = groupsId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {
        return id;
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


}
