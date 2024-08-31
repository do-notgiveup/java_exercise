package com.example.demo_spring_security.controller;

import com.example.demo_spring_security.entity.Account;
import com.example.demo_spring_security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String register() {
        return "registerUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(
            @ModelAttribute Account account,
            Model model
    )
    {
        Integer id = accountService.save(account).getId();
        String message = "User '"+id+"' saved successfully !";
        model.addAttribute("msg", message);
        return "registerUser";
    }
}
