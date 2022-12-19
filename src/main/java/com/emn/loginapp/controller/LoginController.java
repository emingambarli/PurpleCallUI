package com.emn.loginapp.controller;

import com.emn.loginapp.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login()
    {
        return "../static/login";
    }
    @GetMapping ("/login")
    public String userVerification(@ModelAttribute Users users)
    {
        //Users users1 = new Users(null, "emin", "email@email.com", "EEee0816624!");
        System.out.println(users.toString());
        return "../static/dashboard";
    }
}
