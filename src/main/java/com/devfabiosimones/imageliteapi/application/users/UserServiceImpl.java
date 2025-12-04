package com.devfabiosimones.imageliteapi.application.users;

import com.devfabiosimones.imageliteapi.domain.AccessToken;
import com.devfabiosimones.imageliteapi.domain.entity.User;
import com.devfabiosimones.imageliteapi.domain.exception.DuplicatedTupleException;
import com.devfabiosimones.imageliteapi.domain.service.UserService;
import com.devfabiosimones.imageliteapi.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User save(User user) {
        var possibleUser = getByEmail(user.getEmail());

        if (possibleUser != null) {
            throw new DuplicatedTupleException("User with email " + user.getEmail() + " already exists.");
        }

        return userRepository.save(user);
    }

    @Override
    public AccessToken authenticate(String email, String password) {
        return null;
    }
}
