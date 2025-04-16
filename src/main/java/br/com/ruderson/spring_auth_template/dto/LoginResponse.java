package br.com.ruderson.spring_auth_template.dto;

public record LoginResponse(
        String accessToken,
        String refreshToken,
        Long expiresIn
) {
}
