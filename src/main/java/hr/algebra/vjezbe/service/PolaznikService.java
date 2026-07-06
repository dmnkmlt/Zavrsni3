package hr.algebra.vjezbe.service;

import hr.algebra.vjezbe.dto.PolaznikDto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PolaznikService {

    List<PolaznikDto> findAll();

    Optional<PolaznikDto> findById(BigInteger id);
}
