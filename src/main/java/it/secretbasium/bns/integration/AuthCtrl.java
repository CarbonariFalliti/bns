package it.secretbasium.bns.integration;

import java.security.Principal;

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

import it.secretbasium.bns.entities.Person;
import it.secretbasium.bns.service.GiftService;
import it.secretbasium.bns.service.PersonService;


@RestController
public class AuthCtrl implements ErrorController{
    @Autowired
    PersonService ps;
    @Autowired
    GiftService gs;


    @GetMapping("/")
    public ModelAndView getIndex(Model m) {
        System.out.println("sono in index");
        ModelAndView mv = new ModelAndView("index");
        System.out.println(mv);
        return mv;

    }
    @GetMapping("/error")
    public ModelAndView getError(Model m) {
        System.out.println("sono in error");
        return new ModelAndView("error");
    }
    @GetMapping("/not-restricted")
    public String notRestricted() {
        return "not-restricted";
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
        m.addAttribute("groupGifts", gs.findByGroupId(null));
        return new ModelAndView("feed");
    }
}
