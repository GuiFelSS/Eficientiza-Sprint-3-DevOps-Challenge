package fiap.com.br.eficientiza.controller;

import fiap.com.br.eficientiza.entity.HistoricoMoto;
import fiap.com.br.eficientiza.service.HistoricoMotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicos")
public class HistoricoMotoController {

    @Autowired
    private HistoricoMotoService historicoService;

    @PostMapping
    public HistoricoMoto criar(@RequestBody HistoricoMoto historico) {
        return historicoService.salvar(historico);
    }

    @GetMapping
    public List<HistoricoMoto> listar() {
        return historicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public HistoricoMoto buscarPorId(@PathVariable Long id) {
        return historicoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        historicoService.deletar(id);
    }
}
