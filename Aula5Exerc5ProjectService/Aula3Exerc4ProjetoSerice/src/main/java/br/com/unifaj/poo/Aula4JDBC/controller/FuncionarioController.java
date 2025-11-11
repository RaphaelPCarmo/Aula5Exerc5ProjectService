package br.com.unifaj.poo.Aula4JDBC.controller;

import br.com.unifaj.poo.Aula4JDBC.Retorno;
import br.com.unifaj.poo.Aula4JDBC.dao.FuncionarioDao;
import br.com.unifaj.poo.Aula4JDBC.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioDao dao;

    @PostMapping("/funcionario")
    public Retorno incluir(@RequestBody Funcionario f) {
        try {
            dao.inserir(f);
            return new Retorno("Funcionário incluído com sucesso!");
        } catch (Exception e) {
            return new Retorno("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/funcionario")
    public List<Funcionario> listar() throws Exception {
        return dao.listar();
    }

    @DeleteMapping("/funcionario/{id}")
    public Retorno excluir(@PathVariable int id) {
        return dao.excluir(id);
    }
}
