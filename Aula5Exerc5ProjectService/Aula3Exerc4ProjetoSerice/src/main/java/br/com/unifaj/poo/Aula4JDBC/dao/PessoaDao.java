package br.com.unifaj.poo.Aula4JDBC.dao;

import br.com.unifaj.poo.Aula4JDBC.Retorno;
import br.com.unifaj.poo.Aula4JDBC.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Pessoa inserir(Pessoa p) throws Exception {
        String sql = "INSERT INTO Pessoa (nome, endereco, telefone) VALUES (?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getTelefone());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) p.setId(rs.getInt(1));
            return p;
        }
    }

    public List<Pessoa> listar() throws Exception {
        String sql = "SELECT * FROM Pessoa ORDER BY id";
        List<Pessoa> pessoas = new ArrayList<>();
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                pessoas.add(p);
            }
        }
        return pessoas;
    }

    public Pessoa buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Pessoa WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                return p;
            }
            return null;
        }
    }

    public Retorno atualizar(Pessoa p) {
        String sql = "UPDATE Pessoa SET nome=?, endereco=?, telefone=? WHERE id=?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getTelefone());
            ps.setInt(4, p.getId());
            int rows = ps.executeUpdate();
            return rows > 0 ? new Retorno("Pessoa atualizada!") : new Retorno("Pessoa não encontrada!");
        } catch (Exception e) {
            return new Retorno("Erro ao atualizar: " + e.getMessage());
        }
    }

    public Retorno excluir(int id) {
        String sql = "DELETE FROM Pessoa WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0 ? new Retorno("Pessoa excluída!") : new Retorno("Pessoa não encontrada!");
        } catch (Exception e) {
            return new Retorno("Erro ao excluir: " + e.getMessage());
        }
    }
}
