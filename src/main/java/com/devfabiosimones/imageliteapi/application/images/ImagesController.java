package com.devfabiosimones.imageliteapi.application.images;

import com.devfabiosimones.imageliteapi.domain.entity.Image;
import com.devfabiosimones.imageliteapi.domain.enums.ImageExtension;
import com.devfabiosimones.imageliteapi.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImagesController {

    private final ImageService service;
    private final ImageMapper mapper;

    @PostMapping
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags
    ) throws IOException {
        log.info("Imagem recebida! Nome = {}, tags = {}, fileSize = {}", name, tags, file.getSize());
        log.info("Content Type: {}", file.getContentType());
        log.info("Media Type: {}", MediaType.valueOf(file.getContentType()));

        Image image = mapper.mapToImage(file, name, tags);
        Image savedImage = service.save(image);
        URI imageURI = buildImageUrl(savedImage);


        return ResponseEntity.created(imageURI).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id){
        var possibleImage = service.getById(id);
        if (possibleImage.isEmpty())
            return ResponseEntity.notFound().build();

        var image = possibleImage.get();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(image.getExtension().getMediaType());
        headers.setContentLength(image.getSize());
        headers.setContentDispositionFormData("inline; filename=\"" + image.getFileName() + "\"", image.getFileName());

        return new ResponseEntity<>(image.getFile(), headers, HttpStatus.OK);
    }

    private URI buildImageUrl(Image image) {
        String imagePath = "/" + image.getId();
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(imagePath).build().toUri();
    }
}
