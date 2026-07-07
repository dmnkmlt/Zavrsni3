package hr.algebra.vjezbe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.algebra.vjezbe.dto.*;
import hr.algebra.vjezbe.repository.UpisRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UpisControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UpisRepository upisRepository;

    private UpisDto upisDto;
    private ProgramObrazovanjaDto programObrazovanjaDto;
    private PolaznikDto polaznikDto;

    @Autowired
    private AuthController authController;

    private String accessToken;

    @BeforeEach
    public void setUp() throws Exception {

        AuthRequestDTO authRequest = new AuthRequestDTO();
        authRequest.setUsername("user");
        authRequest.setPassword("user");

        JwtResponseDTO jwtResponse = authController.authenticateAndGetToken(authRequest);
        accessToken = jwtResponse.getAccessToken();

        upisDto = new UpisDto();

        programObrazovanjaDto = new ProgramObrazovanjaDto();
        programObrazovanjaDto.setNaziv("NekiJavaCourse");
        programObrazovanjaDto.setCsvet(8);

        polaznikDto = new PolaznikDto();
        polaznikDto.setIme("Ivo");
        polaznikDto.setPrezime("Ivić");


        upisDto.setPolaznikDto(polaznikDto);
        upisDto.setProgramObrazovanjaDto(programObrazovanjaDto);

    }

    @Test
    public void testGetAll() throws Exception {

        mockMvc.perform(get("/upis")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].programObrazovanjaDto.naziv", is("Java Course")))
                .andExpect(jsonPath("$[0].programObrazovanjaDto.csvet", is(12)))
                .andExpect(jsonPath("$[0].polaznikDto.ime", is("Ivo")))
                .andExpect(jsonPath("$[0].polaznikDto.prezime", is("Ivić")));
    }

    @Test
    public void testGetById() throws Exception {

        mockMvc.perform(get("/upis/1")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.programObrazovanjaDto.naziv", is("Java Course")))
                .andExpect(jsonPath("$.programObrazovanjaDto.csvet", is(12)))
                .andExpect(jsonPath("$.polaznikDto.ime", is("Ivo")))
                .andExpect(jsonPath("$.polaznikDto.prezime", is("Ivić")));
    }
}
