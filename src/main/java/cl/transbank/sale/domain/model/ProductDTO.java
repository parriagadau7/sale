package cl.transbank.sale.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductDTO {

    @NotNull(message = "name must not null")
    @NotEmpty(message = "name is mandatory")
    private String name;
    @NotNull(message = "price must not null")
    @Min(value = 1, message = "price must be greater or equal than 1")
    private double price;
    @NotNull(message = "quantity must not null")
    @Min(value = 1, message = "quantity must be greater or equal than 1")
    private int quantity;
}
