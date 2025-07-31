package io.github.smfmo.desafio_anota_ai.service;

import io.github.smfmo.desafio_anota_ai.domain.category.exception.CategoryNotFoundException;
import io.github.smfmo.desafio_anota_ai.domain.product.Product;
import io.github.smfmo.desafio_anota_ai.domain.product.ProductDto;
import io.github.smfmo.desafio_anota_ai.domain.product.ProductMapper;
import io.github.smfmo.desafio_anota_ai.domain.product.exception.ProductNotFoundException;
import io.github.smfmo.desafio_anota_ai.repository.ProductRepository;
import io.github.smfmo.desafio_anota_ai.service.aws.AwsSnsService;
import io.github.smfmo.desafio_anota_ai.service.aws.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final ProductMapper mapper;
    private final AwsSnsService awsSnsService;


    public Product insert(ProductDto productDto) {
        categoryService.findById(productDto.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        var entity = mapper.toEntity(productDto);

        repository.save(entity);
        System.out.println(entity);

        awsSnsService.publish(new MessageDto(entity.toString()));

        return entity;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product update(String id, ProductDto productDto) {
        var product = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if (productDto.categoryId() != null) {
            categoryService.findById(productDto.categoryId())
                    .orElseThrow(CategoryNotFoundException::new);
            product.setCategoryId(productDto.categoryId());
        }
        if (!productDto.title().isEmpty()){
            product.setTitle(productDto.title());
        }
        if (!productDto.description().isEmpty()){
            product.setDescription(productDto.description());
        }
        if (!(productDto.price() == null)){
            product.setPrice(productDto.price());
        }

        repository.save(product);

        awsSnsService.publish(new MessageDto(product.toString()));

        return product;
    }

    public void delete(String id) {
        var product = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        repository.delete(product);
        awsSnsService.publish(new MessageDto(product.deleteToString()));
    }
}
