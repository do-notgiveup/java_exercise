package vn.edu.likelion.basic_authentication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.edu.likelion.basic_authentication.entities.UserEntity;
import vn.edu.likelion.basic_authentication.repositories.UserEntityRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userEntityRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities("USER").build();
        return user;
    }
}
