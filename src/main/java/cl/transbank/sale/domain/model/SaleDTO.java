package cl.transbank.sale.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class SaleDTO {

    private Long id;
    private double total;
    private LocalDateTime created;
    @NotNull(message = "client must not null")
    private @Valid ClientDTO client;
    @NotNull(message = "products must not null")
    @NotEmpty(message = "products is mandatory")
    private Set<@Valid ProductDTO> products;
}
