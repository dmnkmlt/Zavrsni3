package hr.algebra.vjezbe.service.impl;

import hr.algebra.vjezbe.dto.PolaznikDto;
import hr.algebra.vjezbe.repository.PolaznikRepository;
import hr.algebra.vjezbe.service.PolaznikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PolaznikServiceImpl implements PolaznikService {

    private PolaznikRepository polaznikRepository;

    @Override
    public List<PolaznikDto> findAll() {
        return polaznikRepository.findAll().stream().map(PolaznikDto::new).collect(Collectors.toList());
    }

    @Override
    public Optional<PolaznikDto> findById(BigInteger id) {
        return polaznikRepository.findById(id).map(PolaznikDto::new);
    }
}
