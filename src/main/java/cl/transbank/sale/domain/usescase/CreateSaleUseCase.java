package cl.transbank.sale.domain.usescase;

import cl.transbank.sale.data.repository.SaleRepository;
import cl.transbank.sale.domain.mapper.SaleMapper;
import cl.transbank.sale.domain.model.SaleDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateSaleUseCase {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public void create(SaleDTO saleDTO) {
         saleRepository.save(saleMapper.convert(saleDTO));
    }
}
