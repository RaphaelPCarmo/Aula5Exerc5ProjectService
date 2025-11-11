package br.com.unifaj.poo.Aula4JDBC.model;

import br.com.unifaj.poo.Aula4JDBC.FuncionarioItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    private Integer id;
    private String nome;
    private String cargo;
    private Double salario;

    private List<FuncionarioItem> itens = new ArrayList<>();
}
