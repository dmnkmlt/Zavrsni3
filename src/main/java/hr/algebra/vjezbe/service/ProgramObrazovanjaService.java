package hr.algebra.vjezbe.service;

import hr.algebra.vjezbe.dto.ProgramObrazovanjaDto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ProgramObrazovanjaService {

    List<ProgramObrazovanjaDto> findAll();

    Optional<ProgramObrazovanjaDto> findById(BigInteger id);

}
