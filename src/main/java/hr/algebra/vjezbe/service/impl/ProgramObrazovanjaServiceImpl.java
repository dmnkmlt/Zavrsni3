package hr.algebra.vjezbe.service.impl;

import hr.algebra.vjezbe.dto.ProgramObrazovanjaDto;
import hr.algebra.vjezbe.repository.ProgramObrazovanjaRepository;
import hr.algebra.vjezbe.service.ProgramObrazovanjaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramObrazovanjaServiceImpl implements ProgramObrazovanjaService {

    private ProgramObrazovanjaRepository programObrazovanjaRepository;

    public List<ProgramObrazovanjaDto> findAll() {
        return programObrazovanjaRepository.findAll().stream().map(ProgramObrazovanjaDto::new).collect(Collectors.toList());
    }

    public Optional<ProgramObrazovanjaDto> findById(BigInteger id) {
        return programObrazovanjaRepository.findById(id).map(ProgramObrazovanjaDto::new);
    }
}
