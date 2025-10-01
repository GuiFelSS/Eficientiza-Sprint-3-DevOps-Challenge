package fiap.com.br.eficientiza.repository;

import fiap.com.br.eficientiza.entity.Estacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacaoRepository extends JpaRepository<Estacao, Long> {
}
