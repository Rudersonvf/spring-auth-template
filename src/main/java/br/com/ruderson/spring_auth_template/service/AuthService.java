package br.com.ruderson.spring_auth_template.service;

import br.com.ruderson.spring_auth_template.dto.LoginRequest;
import br.com.ruderson.spring_auth_template.dto.LoginResponse;
import br.com.ruderson.spring_auth_template.dto.RefreshRequest;
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

    @Autowired
    private RefreshTokenService refreshTokenService;

    public LoginResponse authenticate(LoginRequest loginRequest) {
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.username());
        if (!passwordEncoder.matches(loginRequest.password(), userDetails.getPassword())) {
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }

        String accessToken = tokenService.generateToken(userDetails);
        String refreshToken = refreshTokenService.createRefreshToken(userDetails.getUsername());

        return new LoginResponse(accessToken, refreshToken, tokenService.getExpiration());
    }

    public LoginResponse refresh(RefreshRequest refreshRequest) {
        String username = refreshTokenService.validateRefreshToken(refreshRequest.refreshToken());
        if (username == null) throw new BadCredentialsException("Refresh token inválido");

        UserDetails userDetails = userService.loadUserByUsername(username);
        String newAccessToken = tokenService.generateToken(userDetails);
        String newRefreshToken = refreshTokenService.createRefreshToken(username);

        refreshTokenService.invalidate(refreshRequest.refreshToken());

        return new LoginResponse(newAccessToken, newRefreshToken, tokenService.getExpiration());
    }
}
