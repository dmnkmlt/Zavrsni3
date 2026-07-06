package hr.algebra.vjezbe.service;

import hr.algebra.vjezbe.dto.UpisDto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UpisService {

    List<UpisDto> findAll();

    Optional<UpisDto> findById(BigInteger id);
}
