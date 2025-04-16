package br.com.ruderson.spring_auth_template.controller;

import br.com.ruderson.spring_auth_template.dto.LoginRequest;
import br.com.ruderson.spring_auth_template.dto.LoginResponse;
import br.com.ruderson.spring_auth_template.service.AuthService;
import br.com.ruderson.spring_auth_template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
