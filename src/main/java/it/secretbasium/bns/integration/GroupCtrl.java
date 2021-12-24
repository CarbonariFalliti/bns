package it.secretbasium.bns.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.secretbasium.bns.entities.Group;
import it.secretbasium.bns.entities.Person;
import it.secretbasium.bns.service.GroupService;

@RestController
public class GroupCtrl {

    @Autowired
    GroupService groupService;
    @Autowired
    PersonCtrl personCtrl;

    @PostMapping("/group-creator")
    public Group createGroup(
        @RequestParam(value = "name") String name, 
        @RequestParam(value = "groupemail") String groupemail,
        @RequestParam(value = "password") String password,
        @RequestParam(value = "budget") Integer budget,
        @RequestParam(value = "members") String[] members) {
        
            Group group = groupService.addGroup(new Group());
            group.setName(name);
            group.setGroupEmail(groupemail);
            group.setPassword(password);
            group.setBudget(budget);
            List<String> memberList = new java.util.ArrayList();
            for (String member : members) {
                
                memberList.add(personCtrl.checkPersonExistsAndCreate(member, group.getId()).getId());
            }   
            group.setMembers(memberList);
            return groupService.updateGroup(group); 
    }

    @GetMapping("/group")
    public Group getGroup(@RequestParam(value = "id") String id) {
        return groupService.getGroupById(id);
    }
    @PutMapping("/group")
    public Group updateGroup(Group group) {
        return groupService.updateGroup(group);
    }
    @PostMapping("/group")
    public Group addGroup(Group group) {
        return groupService.addGroup(group);
    }
    @DeleteMapping("/group")
    public void deleteGroup(String id) {
        groupService.deleteGroup(id);
    }
    @GetMapping("/group/members")
    public List<Person> getMembers(String id) {
        return groupService.getMembers(id);
    }
   

}
