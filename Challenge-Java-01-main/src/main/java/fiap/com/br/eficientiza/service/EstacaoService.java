package fiap.com.br.eficientiza.service;

import fiap.com.br.eficientiza.entity.Estacao;
import fiap.com.br.eficientiza.exception.ResourceNotFoundException;
import fiap.com.br.eficientiza.repository.EstacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacaoService {

    @Autowired
    private EstacaoRepository repository;

    public Estacao salvar(Estacao estacao) {
        return repository.save(estacao);
    }

    public List<Estacao> listarTodos() {
        return repository.findAll();
    }

    public Estacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estação com ID " + id + " não encontrada."));
    }

    public Estacao atualizar(Long id, Estacao estacaoAtualizada) {
        Estacao existente = buscarPorId(id);

        existente.setNome(estacaoAtualizada.getNome());
        existente.setLocalizacao(estacaoAtualizada.getLocalizacao());
        existente.setCapacidade(estacaoAtualizada.getCapacidade());
        existente.setStatus(estacaoAtualizada.getStatus());
        existente.setDataCriacao(estacaoAtualizada.getDataCriacao());
        existente.setDataAtualizacao(estacaoAtualizada.getDataAtualizacao());
        existente.setResponsavel(estacaoAtualizada.getResponsavel());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Estação com ID " + id + " não encontrada para exclusão.");
        }
        repository.deleteById(id);
    }
}
