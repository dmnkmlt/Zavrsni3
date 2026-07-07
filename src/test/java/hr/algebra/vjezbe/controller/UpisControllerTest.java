package hr.algebra.vjezbe.controller;

import hr.algebra.vjezbe.dto.UpisDto;
import hr.algebra.vjezbe.service.UpisService;
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

public class UpisControllerTest {
    @Mock
    private UpisService upisService;

    @InjectMocks
    private UpisController upisController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        List<UpisDto> upisDtoList = List.of(new UpisDto(), new UpisDto());

        when(upisService.findAll()).thenReturn(upisDtoList);

        List<UpisDto> result = upisController.getAll();

        assertEquals(2, result.size());
        UpisService verified = verify(upisService);
        verified.findAll();
    }

    @Test
    public void testGetById_Found() {
        BigInteger id = BigInteger.valueOf(1);
        UpisDto upisDto = new UpisDto();
        when(upisService.findById(id)).thenReturn(Optional.of(upisDto));

        UpisDto result = upisController.getById(id).get();

        assertEquals(upisDto, result);
        UpisService verified = verify(upisService);
        verified.findById(id);
    }

    @Test
    public void testGetById_NotFound() {
        BigInteger id = BigInteger.valueOf(12345);
        when(upisService.findById(id)).thenReturn(Optional.empty());

        Optional<UpisDto> result = upisController.getById(id);

        assertTrue(result.isEmpty());

        UpisService verified = verify(upisService);
        verified.findById(id);
    }
}
