package cl.duoc.catalogo.controller;

import cl.duoc.catalogo.dto.request.ProductRequestDto;
import cl.duoc.catalogo.dto.response.ProductResponseDto;
import cl.duoc.catalogo.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/by-ids")
    public ResponseEntity<List<ProductResponseDto>> getByIds(
            @Parameter(description = "Lista de IDs de productos",
                    schema = @Schema(
                            type = "array",
                            example = "[1, 2]"
                    ))
            @RequestParam List<Long> ids)
    {
        return ResponseEntity.ok(service.getByIds(ids));
    }


    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDto>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(service.getByNameContainingIgnoreCase(name));
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponseDto>> getByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(service.getByCategoryId(categoryId));
    }


    @GetMapping("/category/{categoryId}/price")
    public ResponseEntity<List<ProductResponseDto>> getByCategoryIdAndPriceBetween(
            @PathVariable Long categoryId,
            @RequestParam Integer minPrice,
            @RequestParam Integer maxPrice
    ) {
        return ResponseEntity.ok(
                service.getByCategoryIdAndPriceBetween(categoryId, minPrice, maxPrice)
        );
    }


    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@Valid @RequestBody ProductRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDto dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
