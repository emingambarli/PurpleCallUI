package com.emn.loginapp.controller;

import com.emn.loginapp.Repository.UserRepo;
import com.emn.loginapp.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
    @Autowired
    UserRepo userRepo;
    @GetMapping("/signup")
    public String signup(){
        return "../static/signup";
    }

    @RequestMapping("/savedata")
    public String saveData(Users users)
    {
        userRepo.save(users);
        return "../static/login";
    }
}
