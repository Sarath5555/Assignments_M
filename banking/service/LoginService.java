// LoginService.java
package com.example.banking.service;

import com.example.banking.entity.Login;

public interface LoginService {
    String register(Login login);
    String login(Login login);
    String logout(String email);
}
