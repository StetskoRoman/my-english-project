package com.rv.english.controllers;

import com.rv.english.models.Account;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MenuController {

    //    @AuthenticationPrincipal Account account
    @GetMapping("/")
    public String helloPage() {

        return "hello";
    }


//    @GetMapping("/hello")
//    public String helloPage2(Map<String, Object> model) {
//
//        return "hello";
//    }
//
//    @GetMapping("/login")
//    public String login(Map<String, Object> model) {
//        return "login";
//    }


}
