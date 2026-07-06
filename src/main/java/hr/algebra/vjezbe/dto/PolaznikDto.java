package hr.algebra.vjezbe.dto;

import hr.algebra.vjezbe.domain.Polaznik;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PolaznikDto {

    @NotBlank
    private String ime;

    @NotBlank
    private String prezime;

    public PolaznikDto(Polaznik polaznik) {
        this.ime = polaznik.getIme();
        this.prezime = polaznik.getPrezime();
    }
}
