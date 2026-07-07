package hr.algebra.vjezbe.controller;

import hr.algebra.vjezbe.dto.ProgramObrazovanjaDto;
import hr.algebra.vjezbe.service.ProgramObrazovanjaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProgramObrazovanjaTest {
    @Mock
    private ProgramObrazovanjaService programObrazovanjaService;

    @InjectMocks
    private ProgramObrazovanjaController programObrazovanjaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        List<ProgramObrazovanjaDto> programObrazovanjaDtoList = List.of(new ProgramObrazovanjaDto(), new ProgramObrazovanjaDto());

        when(programObrazovanjaService.findAll()).thenReturn(programObrazovanjaDtoList);

        List<ProgramObrazovanjaDto> result = programObrazovanjaController.getAll();

        assertEquals(2, result.size());
        ProgramObrazovanjaService verified = verify(programObrazovanjaService);
        verified.findAll();
    }

    @Test
    public void testGetById_Found() {
        BigInteger id = BigInteger.valueOf(1);
        ProgramObrazovanjaDto programObrazovanjaDto = new ProgramObrazovanjaDto();
        when(programObrazovanjaService.findById(id)).thenReturn(Optional.of(programObrazovanjaDto));

        ProgramObrazovanjaDto result = programObrazovanjaController.getById(id).get();

        assertEquals(programObrazovanjaDto, result);
        ProgramObrazovanjaService verified = verify(programObrazovanjaService);
        verified.findById(id);
    }

    @Test
    public void testGetById_NotFound() {
        BigInteger id = BigInteger.valueOf(12345);
        when(programObrazovanjaService.findById(id)).thenReturn(Optional.empty());

        Optional<ProgramObrazovanjaDto> result = programObrazovanjaController.getById(id);

        assertTrue(result.isEmpty());

        ProgramObrazovanjaService verified = verify(programObrazovanjaService);
        verified.findById(id);
    }
}
