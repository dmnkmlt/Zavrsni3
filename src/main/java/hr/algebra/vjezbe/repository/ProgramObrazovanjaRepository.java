package hr.algebra.vjezbe.repository;

import hr.algebra.vjezbe.domain.ProgramObrazovanja;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
@Primary
public interface ProgramObrazovanjaRepository extends JpaRepository<ProgramObrazovanja, BigInteger> {
}
