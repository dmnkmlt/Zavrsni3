package hr.algebra.vjezbe.dto;

import hr.algebra.vjezbe.domain.Upis;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpisDto {

    /*
    @NotBlank
    private BigInteger polaznikId;

    @NotBlank
    private String polaznikIme;

    @NotBlank
    private String polaznikPrezime;


    @NotBlank
    private BigInteger programObrazovanjaId;

    @NotBlank
    private String programObrazovanjaNaziv;

    @NotBlank
    private Integer programObrazovanjaCsvet;

    public UpisDto(Upis upis) {
        this.polaznikId = upis.getPolaznik().getPolaznikId();
        this.polaznikIme = upis.getPolaznik().getIme();
        this.polaznikPrezime = upis.getPolaznik().getPrezime();

        this.programObrazovanjaId = upis.getProgramObrazovanja().getProgramObrazovanjaId();
        this.programObrazovanjaNaziv = upis.getProgramObrazovanja().getNaziv();
        this.programObrazovanjaCsvet = upis.getProgramObrazovanja().getCsvet();
    }
    */

    @NotBlank
    private PolaznikDto polaznikDto;

    @NotBlank
    private ProgramObrazovanjaDto programObrazovanjaDto;

    public UpisDto(Upis upis) {
        this.polaznikDto = new PolaznikDto(upis.getPolaznik());
        this.programObrazovanjaDto = new ProgramObrazovanjaDto(upis.getProgramObrazovanja());
    }
}
