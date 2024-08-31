package com.example.demo_spring_security.service.impl;

import com.example.demo_spring_security.entity.Account;
import com.example.demo_spring_security.repository.AccountRepo;
import com.example.demo_spring_security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Account save(Account account) {
        if(account.getId() == 0) {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
        }
        return accountRepo.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username)
        );
        if (!account.getIsDeleted()){
            return account;
        }
        return null;
    }


}
