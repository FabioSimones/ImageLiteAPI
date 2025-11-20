package com.devfabiosimones.imageliteapi.infra.repository;

import com.devfabiosimones.imageliteapi.domain.entity.Image;
import com.devfabiosimones.imageliteapi.domain.enums.ImageExtension;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagLike(ImageExtension extension, String query){
        //SELECT * FROM IMAGE WHERE 1=1
        Specification<Image> conjuction = (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
        Specification<Image> spec = Specification.where(conjuction);

        if(extension != null){
            //AND EXTENSION = 'PNG'
            Specification<Image> extensionEqual = (root, q, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("extension"), extension);
            spec = spec.and(extensionEqual);
        }

        if(StringUtils.hasText(query)){
            //AND (NAME LIKE 'QUERY' OR TAG LIKE 'QUERY')
            Specification<Image> nameLike = (root, q, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + query.toUpperCase() + "%");
            Specification<Image> tagLike = (root, q, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.upper(root.get("tags")), "%" + query.toUpperCase() + "%");
            Specification<Image> nameOrTagLike = Specification.anyOf(nameLike, tagLike);
            spec = spec.and(nameOrTagLike);
        }

        return findAll(spec);
    }
}
