package hr.algebra.vjezbe.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Upis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger upisId;

    @ManyToOne
    @JoinColumn(name = "program_obrazovanja_id")
    private ProgramObrazovanja programObrazovanja;

    @ManyToOne
    @JoinColumn(name = "polaznik_id")
    private Polaznik polaznik;
}
