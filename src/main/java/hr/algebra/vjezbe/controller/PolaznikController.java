package hr.algebra.vjezbe.controller;

import hr.algebra.vjezbe.dto.PolaznikDto;
import hr.algebra.vjezbe.service.PolaznikService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("polaznik")
@AllArgsConstructor
public class PolaznikController {

    private PolaznikService polaznikService;

    @GetMapping
    public List<PolaznikDto> getAll() {
        return polaznikService.findAll();
    }

    @GetMapping("{id}")
    public Optional<PolaznikDto> getById(@PathVariable BigInteger id) {
        return polaznikService.findById(id);
    }

}
