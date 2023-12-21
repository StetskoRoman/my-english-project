package com.rv.english.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
//    public String login() {
//        return "login";
//    }


}
