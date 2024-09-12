package vn.edu.likelion.ChangePassword.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.likelion.ChangePassword.entity.AuthEntity;

public interface AuthRepository extends JpaRepository<AuthEntity, Integer> {
    AuthEntity findByEmail(String email);

    AuthEntity findByUsername(String username);
}
