package io.github.smfmo.desafio_anota_ai.domain.category;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto dto);
    CategoryDto toDto(Category entity);
}
