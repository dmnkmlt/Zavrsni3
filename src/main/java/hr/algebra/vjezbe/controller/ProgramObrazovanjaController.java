package hr.algebra.vjezbe.controller;

import hr.algebra.vjezbe.dto.ProgramObrazovanjaDto;
import hr.algebra.vjezbe.service.ProgramObrazovanjaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("program-obrazovanja")
@AllArgsConstructor
public class ProgramObrazovanjaController {

    private ProgramObrazovanjaService programObrazovanjaService;

    @GetMapping
    public List<ProgramObrazovanjaDto> getAll() {
        return programObrazovanjaService.findAll();
    }

    @GetMapping("{id}")
    public Optional<ProgramObrazovanjaDto> getById(@PathVariable BigInteger id) {
        return programObrazovanjaService.findById(id);
    }
}
