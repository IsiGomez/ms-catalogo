package cl.duoc.catalogo.controller;

import cl.duoc.catalogo.dto.request.CategoryRequestDto;
import cl.duoc.catalogo.dto.response.CategoryResponseDto;
import cl.duoc.catalogo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @Operation(summary = "Obtener categoria por ID",
            tags = {"Módulo de Categorías → 1. Consultas de Categorías"})
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @Operation(summary = "Obtener todas las categorías",
            tags = {"Módulo de Categorías → 1. Consultas de Categorías"})
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @Operation(summary = "Crear nueva categoria",
            tags = {"Módulo de Categorías → 2. Acciones de Categorías"})
    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@Valid @RequestBody CategoryRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }


    @Operation(summary = "Actualizar categoria existente",
            tags = {"Módulo de Categorías → 2. Acciones de Categorías"})
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDto dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }


    @Operation(summary = "Eliminar categoria por ID",
            tags = {"Módulo de Categorías → 2. Acciones de Categorías"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
