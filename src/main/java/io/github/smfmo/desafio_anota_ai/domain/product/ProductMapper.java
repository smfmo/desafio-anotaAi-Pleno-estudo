package io.github.smfmo.desafio_anota_ai.domain.product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);
    ProductDto toDto(Product product);

}
