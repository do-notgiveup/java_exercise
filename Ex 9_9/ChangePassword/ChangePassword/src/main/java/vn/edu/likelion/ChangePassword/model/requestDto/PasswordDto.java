package vn.edu.likelion.ChangePassword.model.requestDto;

import lombok.Getter;
import lombok.Setter;
import vn.edu.likelion.ChangePassword.validation.ValidPassword;

@Getter
@Setter
public class PasswordDto {

    private String oldPassword;

//    private  String token;

//    @ValidPassword
    private String newPassword;





}