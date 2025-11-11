package br.com.unifaj.poo.Aula4JDBC.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;
}
