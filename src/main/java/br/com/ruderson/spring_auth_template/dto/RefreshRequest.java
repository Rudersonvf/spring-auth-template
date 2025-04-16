package br.com.ruderson.spring_auth_template.dto;

public record RefreshRequest(
        String username,
        String refreshToken
) {
}
