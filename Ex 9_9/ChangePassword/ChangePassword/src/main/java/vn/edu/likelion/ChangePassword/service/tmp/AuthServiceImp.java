package vn.edu.likelion.ChangePassword.service.tmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.likelion.ChangePassword.entity.AuthEntity;
import vn.edu.likelion.ChangePassword.model.requestDto.LoginUserDto;
import vn.edu.likelion.ChangePassword.model.requestDto.RegisterUserDto;
import vn.edu.likelion.ChangePassword.repository.AuthRepository;
import vn.edu.likelion.ChangePassword.service.AuthService;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    private AuthRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public AuthEntity findUserByUsername(final String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public void changeUserPassword(final AuthEntity user, final String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(final AuthEntity user, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    public AuthEntity signup(RegisterUserDto input) {
        AuthEntity user = AuthEntity.builder()
                .username(input.getUsername())
                .password(passwordEncoder.encode(input.getPassword()))
                .email("nghiaphamdev2@gmail.com")
                .build();

        return userRepository.save(user);
    }

    public AuthEntity authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername());
    }
}
