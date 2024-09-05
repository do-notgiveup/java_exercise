package vn.edu.likelion.basic_authentication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.basic_authentication.dtos.LoginUserDto;
import vn.edu.likelion.basic_authentication.dtos.RegisterUserDto;
import vn.edu.likelion.basic_authentication.entities.UserEntity;
import vn.edu.likelion.basic_authentication.responses.LoginResponse;
import vn.edu.likelion.basic_authentication.services.impl.AuthenticationService;
import vn.edu.likelion.basic_authentication.services.impl.JwtService;

@RequestMapping("/auth")
@RestController
@CrossOrigin
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterUserDto registerUserDto) {
        UserEntity registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
