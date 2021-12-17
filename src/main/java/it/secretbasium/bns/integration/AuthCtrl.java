package it.secretbasium.bns.integration;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AuthCtrl implements ErrorController{

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

    @GetMapping("/restricted")
    public String restricted() {
        return "restricted";
    }
}
