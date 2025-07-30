package io.github.smfmo.desafio_anota_ai.service;

import io.github.smfmo.desafio_anota_ai.domain.category.Category;
import io.github.smfmo.desafio_anota_ai.domain.category.exception.CategoryNotFoundException;
import io.github.smfmo.desafio_anota_ai.domain.product.Product;
import io.github.smfmo.desafio_anota_ai.domain.product.ProductDto;
import io.github.smfmo.desafio_anota_ai.domain.product.ProductMapper;
import io.github.smfmo.desafio_anota_ai.domain.product.exception.ProductNotFoundException;
import io.github.smfmo.desafio_anota_ai.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final ProductMapper mapper;

    public Product insert(ProductDto productDto) {
        Category category = categoryService.findById(productDto.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        var Entity = mapper.toEntity(productDto);
        Entity.setCategory(category);
        repository.save(Entity);

        return Entity;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product update(String id, ProductDto productDto) {
        var product = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        categoryService.findById(productDto.categoryId())
                .ifPresent(product::setCategory);

        if (!productDto.title().isEmpty()){
            product.setTitle(productDto.title());
        }
        if (!productDto.description().isEmpty()){
            product.setDescription(productDto.description());
        }
        if (!(productDto.price() == null)){
            product.setPrice(productDto.price());
        }

        return repository.save(product);
    }

    public void delete(String id) {
        var product = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        repository.delete(product);
    }
}
