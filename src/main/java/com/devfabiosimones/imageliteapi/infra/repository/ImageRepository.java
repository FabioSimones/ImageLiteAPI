package com.devfabiosimones.imageliteapi.infra.repository;

import com.devfabiosimones.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
