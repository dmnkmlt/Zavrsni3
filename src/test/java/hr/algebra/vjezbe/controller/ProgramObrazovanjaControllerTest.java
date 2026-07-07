package hr.algebra.vjezbe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.algebra.vjezbe.dto.ProgramObrazovanjaDto;
import hr.algebra.vjezbe.repository.ProgramObrazovanjaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProgramObrazovanjaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProgramObrazovanjaRepository programObrazovanjaRepository;

    private ProgramObrazovanjaDto programObrazovanjaDto;

    @BeforeEach
    public void setUp() throws Exception {

        programObrazovanjaDto = new ProgramObrazovanjaDto();
        programObrazovanjaDto.setNaziv("NekiJavaCourse");
        programObrazovanjaDto.setCsvet(8);

    }

    @Test
    public void testGetAll() throws Exception {

        mockMvc.perform(get("/program-obrazovanja"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].naziv", is("Java Course")))
                .andExpect(jsonPath("$[0].csvet", is(12)));
    }

    @Test
    public void testGetById() throws Exception {

        mockMvc.perform(get("/program-obrazovanja/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.naziv", is("Java Course")))
                .andExpect(jsonPath("$.csvet", is(12)));
    }
}
