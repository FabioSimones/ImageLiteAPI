package com.devfabiosimones.imageliteapi.infra.repository;

import com.devfabiosimones.imageliteapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
