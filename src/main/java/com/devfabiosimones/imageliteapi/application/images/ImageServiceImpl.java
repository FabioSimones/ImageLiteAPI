package com.devfabiosimones.imageliteapi.application.images;

import com.devfabiosimones.imageliteapi.domain.entity.Image;
import com.devfabiosimones.imageliteapi.domain.service.ImageService;
import com.devfabiosimones.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    @Transactional
    public Image save(Image image) {

        return imageRepository.save(image);
    }
}
