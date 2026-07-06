package hr.algebra.vjezbe.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramObrazovanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger programObrazovanjaId;

    private String naziv;

    private Integer csvet;

    @OneToMany(mappedBy = "programObrazovanja")
    private List<Upis> upisi = new ArrayList<>();
}
