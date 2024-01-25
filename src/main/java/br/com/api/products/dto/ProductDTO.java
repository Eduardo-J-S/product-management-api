package br.com.api.products.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name is required!")
    private String name;

    @NotBlank(message = "The brand name is required!")
    private String brand;
}
