package vn.edu.likelion.basic_authentication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {

    private String password;
    private String username;

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                ", password='" + password + '\'' +
                ", fullName='" + username + '\'' +
                '}';
    }
}
