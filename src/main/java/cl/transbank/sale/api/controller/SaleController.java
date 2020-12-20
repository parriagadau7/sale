package cl.transbank.sale.api.controller;

import cl.transbank.sale.domain.model.SaleDTO;
import cl.transbank.sale.domain.usescase.CreateSaleUseCase;
import cl.transbank.sale.domain.usescase.GetSalesUseCase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sale")
public class SaleController {

    private final CreateSaleUseCase createSaleUseCase;
    private final GetSalesUseCase getSalesUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Sale")
    public void create(@Valid @RequestBody SaleDTO saleDTO) {
        createSaleUseCase.create(saleDTO);
    }

    @GetMapping
    @Operation(summary = "Get List Sale")
    public List<SaleDTO> list() {
        return getSalesUseCase.get();
    }
}
