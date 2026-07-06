package hr.algebra.vjezbe.controller;

import hr.algebra.vjezbe.dto.UpisDto;
import hr.algebra.vjezbe.service.UpisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("upis")
@AllArgsConstructor
public class UpisController {

    private UpisService upisService;

    @GetMapping
    public List<UpisDto> getAll() {
        return upisService.findAll();
    }

    @GetMapping("{id}")
    public Optional<UpisDto> getById(@PathVariable BigInteger id) {
        return upisService.findById(id);
    }
}
