package br.com.unifaj.poo.Aula4JDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {
    private Integer id;
    private String nome;
    private String estado; // planejado, ativo, terminado, cancelado
    private Integer qtdPessoas;
    private String gestorProjeto;
    private String liderTecnico;
    private String gerente;
    private String dataInicio;
    private String dataFim;
    private List<Funcionario> funcionarios = new ArrayList<>();
}
