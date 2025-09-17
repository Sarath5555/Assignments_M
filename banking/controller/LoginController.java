// LoginController.java
package com.example.banking.controller;

import com.example.banking.entity.Login;
import com.example.banking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public String register(@RequestBody Login login) {
        return loginService.register(login);
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        return loginService.login(login);
    }

    @PostMapping("/logout/{email}")
    public String logout(@PathVariable String email) {
        return loginService.logout(email);
    }
}
