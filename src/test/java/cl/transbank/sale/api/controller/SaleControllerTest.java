package cl.transbank.sale.api.controller;

import cl.transbank.sale.api.config.BaseIntegrationTest;
import cl.transbank.sale.domain.model.SaleDTO;
import cl.transbank.sale.domain.usescase.CreateSaleUseCase;
import cl.transbank.sale.domain.usescase.GetSalesUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SaleController.class)
class SaleControllerTest extends BaseIntegrationTest {

    @MockBean
    private CreateSaleUseCase createSaleUseCase;

    @MockBean
    private GetSalesUseCase getSalesUseCase;

    @Test
    void createOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/sale")
                .content("{\n" +
                        "    \"client\":{\n" +
                        "        \"name\":\"Cristian\",\n" +
                        "        \"lastName\":\"Fuentes\",\n" +
                        "        \"email\":\"cfuentes@gmail.com\",\n" +
                        "        \"phone\":\"987435748\"\n" +
                        "    },\n" +
                        "    \"products\":[\n" +
                        "        {   \n" +
                        "            \"name\": \"pala\",\n" +
                        "            \"price\": 10500,\n" +
                        "            \"quantity\":2\n" +
                        "        },\n" +
                        "        {   \n" +
                        "            \"name\": \"serrucho\",\n" +
                        "            \"price\": 7000,\n" +
                        "            \"quantity\":1\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, generateJwtToken())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        String resultDOW = result.getResponse().getContentAsString();
        assertNotNull(resultDOW);
    }

    @Test
    void createNOk() throws Exception {

        Mockito.when(getSalesUseCase.get()).thenReturn(getListSaleDTO());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/sale")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"client\":{\n" +
                        "        \"name\":\"Cristian\",\n" +
                        "        \"lastName\":\"Fuentes\",\n" +
                        "        \"email\":\"cfuentes@gmail.com\",\n" +
                        "        \"phone\":\"987435748\"\n" +
                        "    },\n" +
                        "    \"products\":[\n" +
                        "        {   \n" +
                        "            \"name\": \"pala\",\n" +
                        "            \"price\": 10500,\n" +
                        "            \"quantity\":2\n" +
                        "        },\n" +
                        "        {   \n" +
                        "            \"name\": \"serrucho\",\n" +
                        "            \"price\": 7000,\n" +
                        "            \"quantity\":1\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void listOk() throws Exception {

        Mockito.when(getSalesUseCase.get()).thenReturn(getListSaleDTO());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/sale")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, generateJwtToken())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultDOW = result.getResponse().getContentAsString();
        assertNotNull(resultDOW);
        List<SaleDTO> saleDTO = objectMapper.readValue(resultDOW, List.class);
        assertFalse(saleDTO.isEmpty());
        assertEquals(2, saleDTO.size());
    }

    @Test
    void listNOk() throws Exception {

        Mockito.when(getSalesUseCase.get()).thenReturn(getListSaleDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/sale")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}