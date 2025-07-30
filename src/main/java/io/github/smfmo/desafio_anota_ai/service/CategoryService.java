package io.github.smfmo.desafio_anota_ai.service;

import io.github.smfmo.desafio_anota_ai.domain.category.Category;
import io.github.smfmo.desafio_anota_ai.domain.category.CategoryDto;
import io.github.smfmo.desafio_anota_ai.domain.category.CategoryMapper;
import io.github.smfmo.desafio_anota_ai.domain.category.exception.CategoryNotFoundException;
import io.github.smfmo.desafio_anota_ai.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public Category insert(CategoryDto categoryDto) {
        var Entity = mapper.toEntity(categoryDto);
        repository.save(Entity);
        return Entity;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Optional<Category> findById(String id) {
        return repository.findById(id);
    }

    public Category update(String id, CategoryDto categoryDto) {
        var category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        if (!categoryDto.title().isEmpty()){
            category.setTitle(categoryDto.title());
        }
        if (!categoryDto.description().isEmpty()){
            category.setDescription(categoryDto.description());
        }
        return repository.save(category);
    }

    public void delete(String id) {
        var category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        repository.delete(category);
    }

}
