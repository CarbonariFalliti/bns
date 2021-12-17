package it.secretbasium.bns.integration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthCtrl{

    @GetMapping("/")
    public String index() {
        return "index";
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
