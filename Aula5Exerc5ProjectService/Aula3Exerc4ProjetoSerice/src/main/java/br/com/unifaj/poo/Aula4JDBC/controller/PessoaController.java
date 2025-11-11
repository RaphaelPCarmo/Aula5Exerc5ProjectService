package br.com.unifaj.poo.Aula4JDBC.controller;

import br.com.unifaj.poo.Aula4JDBC.Retorno;
import br.com.unifaj.poo.Aula4JDBC.dao.PessoaDao;
import br.com.unifaj.poo.Aula4JDBC.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PessoaController {

    @Autowired
    PessoaDao dao;

    @PostMapping("/pessoa")
    public Retorno incluir(@RequestBody Pessoa p) {
        try {
            dao.inserir(p);
            return new Retorno("Pessoa incluída com sucesso!");
        } catch (Exception e) {
            return new Retorno("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/pessoa")
    public List<Pessoa> listar() throws Exception {
        return dao.listar();
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa buscar(@PathVariable int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @PutMapping("/pessoa/{id}")
    public Retorno atualizar(@PathVariable int id, @RequestBody Pessoa p) {
        p.setId(id);
        return dao.atualizar(p);
    }

    @DeleteMapping("/pessoa/{id}")
    public Retorno excluir(@PathVariable int id) {
        return dao.excluir(id);
    }
}
