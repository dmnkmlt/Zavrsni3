package hr.algebra.vjezbe.controller;

import hr.algebra.vjezbe.dto.PolaznikDto;
import hr.algebra.vjezbe.service.PolaznikService;
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

public class PolaznikControllerTest {

    @Mock
    private PolaznikService polaznikService;

    @InjectMocks
    private PolaznikController polaznikController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        List<PolaznikDto> polaznikDtoList = List.of(new PolaznikDto(), new PolaznikDto());

        when(polaznikService.findAll()).thenReturn(polaznikDtoList);

        List<PolaznikDto> result = polaznikController.getAll();

        assertEquals(2, result.size());
        PolaznikService verified = verify(polaznikService);
        verified.findAll();
    }

    @Test
    public void testGetById_Found() {
        BigInteger id = BigInteger.valueOf(1);
        PolaznikDto polaznikDto = new PolaznikDto();
        when(polaznikService.findById(id)).thenReturn(Optional.of(polaznikDto));

        PolaznikDto result = polaznikController.getById(id).get();

        assertEquals(polaznikDto, result);
        PolaznikService verified = verify(polaznikService);
        verified.findById(id);
    }

    @Test
    public void testGetById_NotFound() {
        BigInteger id = BigInteger.valueOf(12345);
        when(polaznikService.findById(id)).thenReturn(Optional.empty());

        Optional<PolaznikDto> result = polaznikController.getById(id);

        assertTrue(result.isEmpty());

        PolaznikService verified = verify(polaznikService);
        verified.findById(id);
    }
}
