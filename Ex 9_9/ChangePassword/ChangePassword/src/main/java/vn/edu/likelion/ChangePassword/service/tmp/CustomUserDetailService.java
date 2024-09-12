package vn.edu.likelion.ChangePassword.service.tmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.edu.likelion.ChangePassword.entity.AuthEntity;
import vn.edu.likelion.ChangePassword.repository.AuthRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AuthRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AuthEntity userEntity = userEntityRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
//                .authorities("ADMIN")
                .build();

        return user;
    }
}
