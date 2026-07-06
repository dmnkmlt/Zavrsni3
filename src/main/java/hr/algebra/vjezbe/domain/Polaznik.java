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
public class Polaznik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger polaznikId;

    private String ime;

    private String prezime;

    @OneToMany(mappedBy = "polaznik")
    private List<Upis> upisi = new ArrayList<>();
}
