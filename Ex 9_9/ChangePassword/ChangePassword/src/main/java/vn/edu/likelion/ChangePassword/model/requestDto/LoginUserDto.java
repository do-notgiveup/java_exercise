package vn.edu.likelion.ChangePassword.model.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "LoginUserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}