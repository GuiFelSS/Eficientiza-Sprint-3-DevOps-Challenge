package fiap.com.br.eficientiza.repository;

import fiap.com.br.eficientiza.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
}
