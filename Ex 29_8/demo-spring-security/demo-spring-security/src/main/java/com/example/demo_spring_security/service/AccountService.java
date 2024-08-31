package com.example.demo_spring_security.service;

import com.example.demo_spring_security.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account save(Account account);
}
