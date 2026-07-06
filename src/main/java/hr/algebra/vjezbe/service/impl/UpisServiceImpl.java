package hr.algebra.vjezbe.service.impl;

import hr.algebra.vjezbe.dto.UpisDto;
import hr.algebra.vjezbe.repository.UpisRepository;
import hr.algebra.vjezbe.service.UpisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UpisServiceImpl implements UpisService {

    private UpisRepository upisRepository;

    public List<UpisDto> findAll() {
        return upisRepository.findAll().stream().map(UpisDto::new).collect(Collectors.toList());
    }

    public Optional<UpisDto> findById(BigInteger id) {
        return upisRepository.findById(id).map(UpisDto::new);
    }
}
