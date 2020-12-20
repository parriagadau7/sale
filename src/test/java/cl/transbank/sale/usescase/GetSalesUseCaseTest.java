package cl.transbank.sale.usescase;

import cl.transbank.sale.data.repository.SaleRepository;
import cl.transbank.sale.domain.mapper.ListSaleDTOMapper;
import cl.transbank.sale.domain.model.SaleDTO;
import cl.transbank.sale.domain.usescase.GetSalesUseCase;;
import cl.transbank.sale.usescase.config.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class GetSalesUseCaseTest extends BaseTest {

    @Mock
    private SaleRepository saleRepository;
    @Mock
    private ListSaleDTOMapper listSaleDTOMapper;

    @InjectMocks
    private GetSalesUseCase getSalesUseCase;

    @Test
    void getOk() {
        Mockito.when(saleRepository.findByCreatedBetween(any(), any())).thenReturn(getSaleList());
        Mockito.when(listSaleDTOMapper.convert(any())).thenReturn(getListSaleDTO());
        List<SaleDTO> response = getSalesUseCase.get();
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @Test
    void getNOk() {
        Mockito.when(saleRepository.findByCreatedBetween(any(), any())).thenReturn(null);
        Mockito.when(listSaleDTOMapper.convert(any())).thenReturn(null);
        List<SaleDTO> response = getSalesUseCase.get();
        assertNull(response);
    }
}