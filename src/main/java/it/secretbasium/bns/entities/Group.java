package it.secretbasium.bns.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groups")
public class Group {
    @Id
    private String id;
    private String name;
    private Integer budget;
    private String groupEmail;
    private String password;
    private List<String> members;
    private List<LocalDate> passedDates;
    private LocalDate nextDate;
    
    public String getGroupEmail() {
        return groupEmail;
    }
    public LocalDate getNextDate() {
        return nextDate;
    }
    public void setNextDate(LocalDate nextDate) {
        this.nextDate = nextDate;
    }
    public List<LocalDate> getPassedDates() {
        return passedDates;
    }
    public void setPassedDates(List<LocalDate> passedDates) {
        this.passedDates = passedDates;
    }
    public void setGroupEmail(String groupEmail) {
        this.groupEmail = groupEmail;
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
    public Integer getBudget() {
        return budget;
    }
    public void setBudget(Integer budget) {
        this.budget = budget;
    }
    public List<String> getMembers() {
        return members;
    }
    public void setMembers(List<String> members) {
        this.members = members;
    }
    
}
