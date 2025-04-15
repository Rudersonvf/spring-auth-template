package br.com.ruderson.spring_auth_template.dto;

public record LoginRequest(
        String username,
        String password
) {
}
