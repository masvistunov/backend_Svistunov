package t1.debute.techradar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import t1.debute.techradar.rest.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
@Autowired
    PasswordEncoder passwordEncoder;
@Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @Override
    public UserDTO createUser(UserDTO user) {
        UserDetails newUser = User.withUsername(user.getUsername()).roles(user.getRole().name()).password(passwordEncoder.encode(user.getPassword())).build();
        jdbcUserDetailsManager.createUser(newUser);
        return user;
    }

    @Override
    public void deleteUser(UserDTO user) {
        jdbcUserDetailsManager.deleteUser(user.getUsername());
    }
}
