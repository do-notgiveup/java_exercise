package vn.edu.likelion.basic_authentication.dtos;

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