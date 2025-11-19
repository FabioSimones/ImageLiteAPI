package com.devfabiosimones.imageliteapi.domain.service;

import com.devfabiosimones.imageliteapi.domain.entity.Image;

import java.util.Optional;

public interface ImageService {

    Image save(Image image);
    Optional<Image> getById(String id);
}
