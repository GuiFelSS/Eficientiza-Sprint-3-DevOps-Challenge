package fiap.com.br.eficientiza.service;

import fiap.com.br.eficientiza.entity.HistoricoMoto;
import fiap.com.br.eficientiza.entity.Moto;
import fiap.com.br.eficientiza.entity.Usuario;
import fiap.com.br.eficientiza.exception.ResourceNotFoundException;
import fiap.com.br.eficientiza.repository.HistoricoMotoRepository;
import fiap.com.br.eficientiza.repository.MotoRepository;
import fiap.com.br.eficientiza.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoMotoService {

    @Autowired
    private HistoricoMotoRepository repository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public HistoricoMoto salvar(HistoricoMoto historico) {
        Long idMoto = historico.getMoto().getId();
        Long idUsuario = historico.getUsuario().getId();

        Moto moto = motoRepository.findById(idMoto)
                .orElseThrow(() -> new ResourceNotFoundException("Moto com ID " + idMoto + " não encontrada."));
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + idUsuario + " não encontrado."));

        historico.setMoto(moto);
        historico.setUsuario(usuario);

        return repository.save(historico);
    }

    public List<HistoricoMoto> listarTodos() {
        return repository.findAll();
    }

    public HistoricoMoto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Histórico com ID " + id + " não encontrado."));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Histórico com ID " + id + " não encontrado para exclusão.");
        }
        repository.deleteById(id);
    }
}
