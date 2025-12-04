package com.devfabiosimones.imageliteapi.application.jwt;

import com.devfabiosimones.imageliteapi.domain.AccessToken;
import com.devfabiosimones.imageliteapi.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public AccessToken generetadToken(User user) {
        return new AccessToken("");
    }
}
