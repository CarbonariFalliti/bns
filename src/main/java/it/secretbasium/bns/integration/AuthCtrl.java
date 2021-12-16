package it.secretbasium.bns.integration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthCtrl{

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
