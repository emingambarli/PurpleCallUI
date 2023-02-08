package com.emn.loginapp.controller;

import com.emn.loginapp.Repository.UserRepo;
import com.emn.loginapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    @Autowired
    UserRepo userRepo;
    @GetMapping("/signup")
    public String signup(){
        return "../static/signup";
    }

    @PostMapping("/savedata")
    public String saveData(Users users)
    {
        //System.out.println();
        //if (users.toString() == ""){
        //    System.out.println("Please Fill The Blanks");
        //}
        //else {
        //
        userRepo.save(users);
        //}
        return "../static/login";
    }
}
