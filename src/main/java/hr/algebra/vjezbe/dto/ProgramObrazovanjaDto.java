package hr.algebra.vjezbe.dto;

import hr.algebra.vjezbe.domain.ProgramObrazovanja;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramObrazovanjaDto {

    @NotBlank
    private String naziv;

    @PositiveOrZero
    @NotBlank
    private Integer csvet;

    public ProgramObrazovanjaDto(ProgramObrazovanja programObrazovanja) {
        this.naziv = programObrazovanja.getNaziv();
        this.csvet = programObrazovanja.getCsvet();
    }
}
