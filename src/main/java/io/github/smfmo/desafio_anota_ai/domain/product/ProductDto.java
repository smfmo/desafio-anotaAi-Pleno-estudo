package io.github.smfmo.desafio_anota_ai.domain.product;

public record ProductDto(
        String title,
        String description,
        Integer price,
        String categoryId,
        String OwnerId
) {
}
