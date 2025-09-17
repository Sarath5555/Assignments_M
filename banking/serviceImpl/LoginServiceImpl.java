// LoginServiceImpl.java
package com.example.banking.serviceImpl;

import com.example.banking.entity.Login;
import com.example.banking.repository.LoginRepository;
import com.example.banking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepo;

    @Override
    public String register(Login login) {
        login.setLoggedIn(false);
        loginRepo.save(login);
        return "Registration Successful";
    }

    @Override
    public String login(Login login) {
        Optional<Login> existing = loginRepo.findByEmail(login.getEmail());
        if (existing.isPresent() && existing.get().getPassword().equals(login.getPassword())) {
            Login l = existing.get();
            l.setLoggedIn(true);
            loginRepo.save(l);
            return "Login Successful";
        }
        return "Invalid Credentials";
    }

    @Override
    public String logout(String email) {
        Optional<Login> existing = loginRepo.findByEmail(email);
        if (existing.isPresent() && existing.get().isLoggedIn()) {
            Login l = existing.get();
            l.setLoggedIn(false);
            loginRepo.save(l);
            return "Logout Successful";
        }
        return "User not logged in";
    }
}
