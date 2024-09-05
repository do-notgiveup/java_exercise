package vn.edu.likelion.basic_authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.basic_authentication.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);

}
