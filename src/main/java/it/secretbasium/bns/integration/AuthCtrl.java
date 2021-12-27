package it.secretbasium.bns.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import it.secretbasium.bns.entities.Gift;
import it.secretbasium.bns.entities.Group;
import it.secretbasium.bns.entities.Person;
import it.secretbasium.bns.service.GiftService;
import it.secretbasium.bns.service.GroupService;
import it.secretbasium.bns.service.PersonService;


@RestController
public class AuthCtrl implements ErrorController{
    @Autowired
    PersonService ps;
    @Autowired
    GiftService gs;
    @Autowired
    GroupService grs;


    @GetMapping("/")
    public ModelAndView getIndex(Model m) {
        ModelAndView mv = new ModelAndView("index");
        return mv;

    }
    @GetMapping("/error")
    public ModelAndView getError(Model m) {
        System.out.println("sono in error");
        return new ModelAndView("error");
    }
    @GetMapping("/group-registration")
    public ModelAndView groupRegistration() {
        return new ModelAndView("group-registration");
    }

    @PostMapping("/login")
    public RedirectView login(
        @RequestParam String email,
        @RequestParam String password
    ) {
    
        Person p= ps.getPersonByEmail(email);
        if (p==null) {
            return new RedirectView("/login?error=true&message=email doesn't exist");
        }
        if (p.getPassword().equals(password)) {
            return new RedirectView("/feed"+"?id="+p.getId());
        }
        return new RedirectView("/login?error=true&message=wrong password");
    }
    @GetMapping("/login")
    public ModelAndView login(
        @RequestParam(value = "error", required = false) boolean error,
        @RequestParam(value = "message", required = false) String message
    ) {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("error", error);
        mv.addObject("message", message);
        return mv;
    }




    @RequestMapping(value =  "/feed", method ={ RequestMethod.GET, RequestMethod.POST}   )
    public ModelAndView restricted(Model m, @Param("id") String id) {
        Person p=ps.getPersonById(id);
        if (p==null) {
            return new ModelAndView("error");
        }
        m.addAttribute("user", p);
        m.addAttribute("basia", gs.findByBasium(p.getId()));
        m.addAttribute("babbi", gs.findByBabbo(p.getId()));
        List<Group> groups=new ArrayList<Group>();
        List<Person> people=new ArrayList<Person>();
        for (String gId : p.getGroupsId()) {
            Group g= grs.getGroupById(gId);
            groups.add(g);
            for (String personId : g.getMembers()) {
                Person person=ps.getPersonById(personId);
                people.add(person);
            }
        }
        m.addAttribute("groups", groups);
        m.addAttribute("people", people);
        

        return new ModelAndView("feed");
    }

    @RequestMapping(value =  "/group-feed", method ={ RequestMethod.GET}   )
    public ModelAndView feedGroup(Model m,@RequestParam String id){
        Group g=grs.getGroupById(id);
        
        m.addAttribute("group", g);

        List<Person> people=new ArrayList<Person>();
        for (String pId : g.getMembers()) {
            people.add(ps.getPersonById(pId));
        }
        m.addAttribute("members", people);

        List<Gift> gifts= gs.findByGroupId(g.getId());
        m.addAttribute("gifts", gifts);
        

        return new ModelAndView("group-page");
    }

    @RequestMapping(value =  "/tickets", method ={ RequestMethod.GET}   )
    public ModelAndView tickets(Model m, @RequestParam String id){
        Person p=ps.getPersonById(id);
        m.addAttribute("user", p);
        return new ModelAndView("help-desk");
    }
}

