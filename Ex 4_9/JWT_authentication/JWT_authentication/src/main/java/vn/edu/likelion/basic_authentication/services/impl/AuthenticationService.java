package vn.edu.likelion.basic_authentication.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.likelion.basic_authentication.dtos.LoginUserDto;
import vn.edu.likelion.basic_authentication.dtos.RegisterUserDto;
import vn.edu.likelion.basic_authentication.entities.UserEntity;
import vn.edu.likelion.basic_authentication.repositories.UserEntityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private final UserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserEntityRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity signup(RegisterUserDto input) {
        UserEntity user = UserEntity.builder()
                .username(input.getUsername())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public UserEntity authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername());
    }

    public List<UserEntity> allUsers() {
        List<UserEntity> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}