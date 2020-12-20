package cl.transbank.sale.usescase.config;

import cl.transbank.sale.data.model.Sale;
import cl.transbank.sale.data.model.User;
import cl.transbank.sale.domain.model.SaleDTO;
import cl.transbank.sale.domain.model.UserDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseTest {

    protected static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjA4NDg2MTg1LCJleHAiOjE2MDg0ODY3ODV9.OHsRdSsvLATb4R31QTQX7UKY5PBkCA6mNToTqFQmfj2Orejqvkepb4pD46JHhX4O9SbkqcpTO61m8U1djq1YGA ";

    protected UserDTO getUserDTO(){
        return UserDTO.builder()
                .username("admin")
                .password("Ajwr,8329.fhdhg#")
                .build();
    }

    protected Optional<User> getUser(){
        User user = new User();
        return Optional.of(user);
    }

    protected Optional<UserDTO> getOptionalUserDTO(){
        return Optional.of(getUserDTO());
    }

    protected List<Sale> getSaleList(){
        List<Sale> saleList = new ArrayList<>();
        Sale sale1 = new Sale();
        Sale sale2 = new Sale();
        saleList.add(sale1);
        saleList.add(sale2);
        return saleList;
    }

    protected List<SaleDTO> getListSaleDTO(){
        List<SaleDTO> saleDTOList = new ArrayList<>();
        SaleDTO saleDTO1 = SaleDTO.builder()
                .id(1l)
                .total(28000)
                .created(LocalDateTime.now())
                .build();
        SaleDTO saleDTO2 = SaleDTO.builder()
                .id(1l)
                .total(28000)
                .created(LocalDateTime.now().minusHours(1))
                .build();
        saleDTOList.add(saleDTO1);
        saleDTOList.add(saleDTO2);
        return saleDTOList;
    }
}
