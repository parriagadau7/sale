package cl.transbank.sale.api.controller;

import cl.transbank.sale.api.config.BaseIntegrationTest;
import cl.transbank.sale.domain.usescase.LoginUseCase;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
class LoginControllerTest extends BaseIntegrationTest {

    @MockBean
    private LoginUseCase loginUseCase;

    @Test
    void login() throws Exception {

        Mockito.when(loginUseCase.login(Mockito.any())).thenReturn(getJwtResponse());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
                .content("{\n" +
                        "    \"username\":\"admin\",\n" +
                        "    \"password\":\"Ajwr,8329.fhdhg#\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultDOW = result.getResponse().getContentAsString();
        assertNotNull(resultDOW);
        JsonNode jsonNode = objectMapper.readTree(resultDOW);
        assertEquals(TOKEN, jsonNode.get("token").asText());
    }
}