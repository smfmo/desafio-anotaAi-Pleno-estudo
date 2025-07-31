package io.github.smfmo.desafio_anota_ai.service;

import io.github.smfmo.desafio_anota_ai.domain.category.Category;
import io.github.smfmo.desafio_anota_ai.domain.category.CategoryDto;
import io.github.smfmo.desafio_anota_ai.domain.category.CategoryMapper;
import io.github.smfmo.desafio_anota_ai.domain.category.exception.CategoryNotFoundException;
import io.github.smfmo.desafio_anota_ai.repository.CategoryRepository;
import io.github.smfmo.desafio_anota_ai.service.aws.AwsSnsService;
import io.github.smfmo.desafio_anota_ai.service.aws.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    private final AwsSnsService awsSnsService;

    public Category insert(CategoryDto categoryDto) {
        var entity = mapper.toEntity(categoryDto);
        repository.save(entity);
        System.out.println(entity);
        awsSnsService.publish(new MessageDto(entity.toString()));
        return entity;
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

        repository.save(category);
        awsSnsService.publish(new MessageDto(category.toString()));

        return category;
    }

    public void delete(String id) {
        var category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        repository.delete(category);
        awsSnsService.publish(new MessageDto(category.deleteToString()));
    }

}
