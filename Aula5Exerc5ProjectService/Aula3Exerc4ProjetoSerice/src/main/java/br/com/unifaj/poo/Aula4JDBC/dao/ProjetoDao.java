package br.com.unifaj.poo.Aula4JDBC.dao;

import br.com.unifaj.poo.Aula4JDBC.Retorno;
import br.com.unifaj.poo.Aula4JDBC.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjetoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Projeto inserir(Projeto p) throws Exception {
        String sql = """
            INSERT INTO Projeto
            (nome, estado, qtdPessoas, gestorProjeto, liderTecnico, gerente, dataInicio, dataFim)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getEstado());
            ps.setInt(3, p.getQtdPessoas());
            ps.setString(4, p.getGestorProjeto());
            ps.setString(5, p.getLiderTecnico());
            ps.setString(6, p.getGerente());
            ps.setString(7, p.getDataInicio());
            ps.setString(8, p.getDataFim());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) p.setId(rs.getInt(1));

            return p;
        }
    }

    public List<Projeto> listar() throws Exception {
        String sql = "SELECT * FROM Projeto ORDER BY id";
        List<Projeto> projetos = new ArrayList<>();

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Projeto p = new Projeto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEstado(rs.getString("estado"));
                p.setQtdPessoas(rs.getInt("qtdPessoas"));
                p.setGestorProjeto(rs.getString("gestorProjeto"));
                p.setLiderTecnico(rs.getString("liderTecnico"));
                p.setGerente(rs.getString("gerente"));
                p.setDataInicio(rs.getString("dataInicio"));
                p.setDataFim(rs.getString("dataFim"));
                projetos.add(p);
            }
        }

        return projetos;
    }

    public Projeto buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Projeto WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Projeto p = new Projeto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEstado(rs.getString("estado"));
                p.setQtdPessoas(rs.getInt("qtdPessoas"));
                p.setGestorProjeto(rs.getString("gestorProjeto"));
                p.setLiderTecnico(rs.getString("liderTecnico"));
                p.setGerente(rs.getString("gerente"));
                p.setDataInicio(rs.getString("dataInicio"));
                p.setDataFim(rs.getString("dataFim"));
                return p;
            }
            return null;
        }
    }

    public Retorno atualizar(Projeto p) {
        String sql = """
            UPDATE Projeto SET nome=?, estado=?, qtdPessoas=?, gestorProjeto=?, 
                liderTecnico=?, gerente=?, dataInicio=?, dataFim=? WHERE id=?
        """;
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEstado());
            ps.setInt(3, p.getQtdPessoas());
            ps.setString(4, p.getGestorProjeto());
            ps.setString(5, p.getLiderTecnico());
            ps.setString(6, p.getGerente());
            ps.setString(7, p.getDataInicio());
            ps.setString(8, p.getDataFim());
            ps.setInt(9, p.getId());
            int rows = ps.executeUpdate();
            return rows > 0 ? new Retorno("Projeto atualizado!") : new Retorno("Projeto não encontrado!");
        } catch (Exception e) {
            return new Retorno("Erro ao atualizar: " + e.getMessage());
        }
    }

    public Retorno excluir(int id) {
        String sql = "DELETE FROM Projeto WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0 ? new Retorno("Projeto excluído!") : new Retorno("Projeto não encontrado!");
        } catch (Exception e) {
            return new Retorno("Erro ao excluir: " + e.getMessage());
        }
    }
}
