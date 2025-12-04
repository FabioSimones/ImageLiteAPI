package com.devfabiosimones.imageliteapi.domain.service;

import com.devfabiosimones.imageliteapi.domain.AccessToken;
import com.devfabiosimones.imageliteapi.domain.entity.User;

public interface UserService {

    User getByEmail(String email);
    User save(User user);
    AccessToken authenticate(String email, String password);
}
