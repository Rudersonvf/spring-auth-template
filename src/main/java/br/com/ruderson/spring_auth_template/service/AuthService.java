package br.com.ruderson.spring_auth_template.service;

import br.com.ruderson.spring_auth_template.dto.LoginRequest;
import br.com.ruderson.spring_auth_template.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public LoginResponse authenticate(LoginRequest loginRequest) {
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.username());

        if (!passwordEncoder.matches(loginRequest.password(), userDetails.getPassword())) {
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }

        String token = tokenService.generateToken(userDetails);

        return new LoginResponse(token, tokenService.getExpiration());
    }
}
