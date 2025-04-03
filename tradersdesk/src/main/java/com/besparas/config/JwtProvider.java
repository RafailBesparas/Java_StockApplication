package com.besparas.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class JwtProvider {

    private static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_Key.getBytes(StandardCharsets.UTF_8));

    public static String generateToken(String subject){
        Collection <? extends GrantedAuthority> authorities = auth.getAuthorities();
        return null;
    }
}
