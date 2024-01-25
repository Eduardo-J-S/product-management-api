package br.com.api.products.dto;


import br.com.api.products.exceptions.GlobalExceptionHandler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    @GlobalExceptionHandler(message = "Product name is invalid!")
    private String name;

    @GlobalExceptionHandler(message = "Product brand is invalid!")
    private String brand;
}
