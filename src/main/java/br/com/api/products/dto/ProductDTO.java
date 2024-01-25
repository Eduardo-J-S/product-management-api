package br.com.api.products.dto;


import br.com.api.products.exceptions.GlobalExceptionHandler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    @GlobalExceptionHandler()
    private String name;

    @GlobalExceptionHandler()
    private String brand;
}
