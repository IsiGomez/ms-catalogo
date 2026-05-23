package cl.duoc.catalogo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String name;
    private String description;
    private Integer price;

    private CategoryResponseDto category;

}