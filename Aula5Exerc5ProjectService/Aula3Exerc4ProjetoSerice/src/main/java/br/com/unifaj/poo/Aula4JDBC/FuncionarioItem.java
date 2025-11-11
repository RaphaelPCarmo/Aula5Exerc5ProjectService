package br.com.unifaj.poo.Aula4JDBC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioItem {
    private Integer id;
    private Integer idFuncionario;
    private String descricao;
    private Integer horas;
}
