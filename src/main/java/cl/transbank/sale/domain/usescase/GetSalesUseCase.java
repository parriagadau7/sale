package cl.transbank.sale.domain.usescase;

import cl.transbank.sale.data.repository.SaleRepository;
import cl.transbank.sale.domain.mapper.ListSaleDTOMapper;
import cl.transbank.sale.domain.model.SaleDTO;
import cl.transbank.sale.domain.util.DateUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetSalesUseCase {

    private final SaleRepository saleRepository;
    private final ListSaleDTOMapper listSaleDTOMapper;

    public List<SaleDTO> get() {
        return listSaleDTOMapper.convert(saleRepository.findByCreatedBetween(DateUtil.getStartDateTime(),
                DateUtil.getEndDateTime()));
    }
}
