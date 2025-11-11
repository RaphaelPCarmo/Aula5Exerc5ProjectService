package br.com.unifaj.poo.Aula4JDBC.controller;

import br.com.unifaj.poo.Aula4JDBC.Retorno;
import br.com.unifaj.poo.Aula4JDBC.dao.ProjetoDao;
import br.com.unifaj.poo.Aula4JDBC.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProjetoController {

    @Autowired
    ProjetoDao dao;

    @PostMapping("/projeto")
    public Retorno incluir(@RequestBody Projeto p) {
        try {
            dao.inserir(p);
            return new Retorno("Projeto incluído com sucesso!");
        } catch (Exception e) {
            return new Retorno("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/projeto")
    public List<Projeto> listar() throws Exception {
        return dao.listar();
    }

    @GetMapping("/projeto/{id}")
    public Projeto buscar(@PathVariable int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @PutMapping("/projeto/{id}")
    public Retorno atualizar(@PathVariable int id, @RequestBody Projeto p) {
        p.setId(id);
        return dao.atualizar(p);
    }

    @DeleteMapping("/projeto/{id}")
    public Retorno excluir(@PathVariable int id) {
        return dao.excluir(id);
    }
}
