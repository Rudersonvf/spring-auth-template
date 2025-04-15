package br.com.ruderson.spring_auth_template.service;

import br.com.ruderson.spring_auth_template.dto.UserDetailsDTO;
import br.com.ruderson.spring_auth_template.entities.Role;
import br.com.ruderson.spring_auth_template.entities.User;
import br.com.ruderson.spring_auth_template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsDTO> result = userRepository.searchUserAndRolesByEmail(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.getFirst().password());
        for (UserDetailsDTO projection : result) {
            user.addRole(new Role(projection.roleId(), projection.authority()));
        }
        return user;
    }
}
