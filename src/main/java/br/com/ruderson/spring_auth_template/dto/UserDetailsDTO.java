package br.com.ruderson.spring_auth_template.dto;

public record UserDetailsDTO(
        String username,
        String password,
        Long roleId,
        String authority
) {
}
