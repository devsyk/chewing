package io.web.chewing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage(){

        System.out.printf("dd");
        return "loginPage";
    }
}
