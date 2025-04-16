package br.com.ruderson.spring_auth_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RefreshTokenService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String createRefreshToken(String username) {
        String refreshToken = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set("refreshToken:" + refreshToken, username);
        redisTemplate.expire("refreshToken:" + refreshToken, 7L, TimeUnit.DAYS);
        return refreshToken;
    }

    public String validateRefreshToken(String refreshToken) {
        return redisTemplate.opsForValue().get("refreshToken:" + refreshToken);
    }

    public void invalidate(String refreshToken) {
        redisTemplate.delete("refreshToken:" + refreshToken);
    }
}
