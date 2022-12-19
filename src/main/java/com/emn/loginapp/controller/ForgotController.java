package com.emn.loginapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotController {
    @GetMapping ("/forgot")
    public String forgot(){
        return "../static/forgot";
    }
}
