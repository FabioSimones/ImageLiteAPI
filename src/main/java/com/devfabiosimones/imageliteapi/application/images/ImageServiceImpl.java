package com.devfabiosimones.imageliteapi.application.images;

import com.devfabiosimones.imageliteapi.domain.entity.Image;
import com.devfabiosimones.imageliteapi.domain.service.ImageService;
import com.devfabiosimones.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    @Transactional
    public Image save(Image image) {

        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> getById(String id) {
        return imageRepository.findById(id);
    }
}
