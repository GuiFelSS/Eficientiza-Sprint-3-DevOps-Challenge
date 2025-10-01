package fiap.com.br.eficientiza.controller;

import fiap.com.br.eficientiza.entity.Estacao;
import fiap.com.br.eficientiza.service.EstacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacoes")
public class EstacaoController {

    @Autowired
    private EstacaoService estacaoService;

    @PostMapping
    public Estacao criar(@RequestBody Estacao estacao) {
        return estacaoService.salvar(estacao);
    }

    @GetMapping
    public List<Estacao> listar() {
        return estacaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Estacao buscarPorId(@PathVariable Long id) {
        return estacaoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Estacao atualizar(@PathVariable Long id, @RequestBody Estacao estacao) {
        return estacaoService.atualizar(id, estacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estacaoService.deletar(id);
    }
}
