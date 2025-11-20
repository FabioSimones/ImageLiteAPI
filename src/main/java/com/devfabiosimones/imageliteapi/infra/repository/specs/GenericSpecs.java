package com.devfabiosimones.imageliteapi.infra.repository.specs;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecs {
    private GenericSpecs(){}

    public static <T> Specification<T> conjuction() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
    }
}
