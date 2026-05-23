package cl.duoc.catalogo.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductRequestDto {

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 100, message = "El nombre del producto no puede superar los 100 caracteres")
    private String name;

    @Size(max = 280, message = "La descripcion no puede superar los 280 caracteres")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    @Max(value = 1000000, message = "El precio no puede superar los 1.000.000")
    private Integer price;

    @NotNull(message = "La categoria es obligatoria")
    @Positive(message = "La categoria debe ser valida")
    private Long categoryId;

}