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
