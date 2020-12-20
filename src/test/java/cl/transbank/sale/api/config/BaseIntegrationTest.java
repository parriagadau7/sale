package cl.transbank.sale.api.config;

import cl.transbank.sale.domain.model.JwtResponse;
import cl.transbank.sale.domain.model.SaleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BaseIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    private static final String BEARER = "Bearer ";
    private static final String USERNAME = "admin ";
    protected static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjA4NDg2MTg1LCJleHAiOjE2MDg0ODY3ODV9.OHsRdSsvLATb4R31QTQX7UKY5PBkCA6mNToTqFQmfj2Orejqvkepb4pD46JHhX4O9SbkqcpTO61m8U1djq1YGA ";
    private JwtProvider jwtProvider;
    protected ObjectMapper objectMapper;



    @BeforeEach
    void setUp() {
        jwtProvider = new JwtProvider();
        objectMapper = new ObjectMapper();
    }

    protected String generateJwtToken(){
       return BEARER + jwtProvider.generateJwtToken(USERNAME);
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

    protected JwtResponse getJwtResponse(){
        return JwtResponse.builder()
                .token(TOKEN)
                .build();
    }
}
