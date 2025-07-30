package io.github.smfmo.desafio_anota_ai.controller;

import io.github.smfmo.desafio_anota_ai.domain.product.Product;
import io.github.smfmo.desafio_anota_ai.domain.product.ProductDto;
import io.github.smfmo.desafio_anota_ai.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        var categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDto productDto){
        var response = service.insert(productDto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product>update(@PathVariable("id") String id,
                                          @RequestBody ProductDto productDto){
        var updateResponse = service.update(id, productDto);
        return ResponseEntity.ok().body(updateResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
