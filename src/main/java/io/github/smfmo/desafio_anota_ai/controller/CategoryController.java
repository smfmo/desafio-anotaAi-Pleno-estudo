package io.github.smfmo.desafio_anota_ai.controller;

import io.github.smfmo.desafio_anota_ai.domain.category.Category;
import io.github.smfmo.desafio_anota_ai.domain.category.CategoryDto;
import io.github.smfmo.desafio_anota_ai.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        var categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDto categoryDto){
        var response = service.insert(categoryDto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category>update(@PathVariable("id") String id,
                                          @RequestBody CategoryDto categoryDto){
        var updateResponse = service.update(id, categoryDto);
        return ResponseEntity.ok().body(updateResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
