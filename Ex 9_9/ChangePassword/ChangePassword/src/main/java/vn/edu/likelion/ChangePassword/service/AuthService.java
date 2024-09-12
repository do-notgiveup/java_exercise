package vn.edu.likelion.ChangePassword.service;

import vn.edu.likelion.ChangePassword.entity.AuthEntity;
import vn.edu.likelion.ChangePassword.model.requestDto.LoginUserDto;
import vn.edu.likelion.ChangePassword.model.requestDto.RegisterUserDto;

public interface AuthService {
    AuthEntity findUserByUsername(String username);

    void changeUserPassword(AuthEntity user, String password);

    boolean checkIfValidOldPassword(AuthEntity user, String password);

    AuthEntity signup(RegisterUserDto input);

    AuthEntity authenticate(LoginUserDto input);
}
