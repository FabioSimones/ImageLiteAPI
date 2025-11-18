package com.devfabiosimones.imageliteapi;

import com.devfabiosimones.imageliteapi.domain.entity.Image;
import com.devfabiosimones.imageliteapi.domain.enums.ImageExtension;
import com.devfabiosimones.imageliteapi.infra.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImageliteapiApplication {
    @Bean
    public CommandLineRunner commandLineRunner(@Autowired ImageRepository repository){
        return args -> {
            Image image = Image.builder()
                    .name("Imagem de Teste")
                    .size(2048L)
                    .extension(ImageExtension.JPG)
                    .tags("teste, imagem")
                    .build();

            repository.save(image);
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(ImageliteapiApplication.class, args);
	}

}
