package fiap.com.br.eficientiza.repository;

import fiap.com.br.eficientiza.entity.HistoricoMoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoMotoRepository extends JpaRepository<HistoricoMoto, Long> {
}
