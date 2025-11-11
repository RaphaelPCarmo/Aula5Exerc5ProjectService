package br.com.unifaj.poo.Aula4JDBC;

public class Retorno {
    public String status;
    public String mensagemFuncionamento;
    public Object object;
    public Retorno(Object obj) {
        this.status = "OK"; this.object = obj;
    }
    public Retorno(String funcionou) {
        this.status = "Funcionou";
        this.mensagemFuncionamento = funcionou;
    }
}
