package br.com.unifaj.poo.Aula4JDBC.dao;

import br.com.unifaj.poo.Aula4JDBC.FuncionarioItem;
import br.com.unifaj.poo.Aula4JDBC.Retorno;
import br.com.unifaj.poo.Aula4JDBC.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class FuncionarioDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Funcionario inserir(Funcionario f) throws Exception {
        String sqlFuncionario = "INSERT INTO Funcionario (nome, cargo, salario) VALUES (?, ?, ?)";
        String sqlItem = "INSERT INTO Funcionario_Item (idFuncionario, descricao, horas) VALUES (?, ?, ?)";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement psFunc = con.prepareStatement(sqlFuncionario, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psItem = con.prepareStatement(sqlItem, Statement.RETURN_GENERATED_KEYS)) {

            con.setAutoCommit(false);

            psFunc.setString(1, f.getNome());
            psFunc.setString(2, f.getCargo());
            psFunc.setDouble(3, f.getSalario());
            psFunc.executeUpdate();

            ResultSet rs = psFunc.getGeneratedKeys();
            rs.next();
            f.setId(rs.getInt(1));

            for (FuncionarioItem item : f.getItens()) {
                item.setIdFuncionario(f.getId());
                psItem.setInt(1, item.getIdFuncionario());
                psItem.setString(2, item.getDescricao());
                psItem.setInt(3, item.getHoras());
                psItem.executeUpdate();

                ResultSet key = psItem.getGeneratedKeys();
                key.next();
                item.setId(key.getInt(1));
            }

            con.commit();
        }

        return f;
    }

    public List<Funcionario> listar() throws Exception {
        String sql = """
            SELECT f.id, f.nome, f.cargo, f.salario,
                   i.id idItem, i.descricao, i.horas
            FROM Funcionario f
            LEFT JOIN Funcionario_Item i ON f.id = i.idFuncionario
        """;

        Map<Integer, Funcionario> funcionarios = new TreeMap<>();

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario f = funcionarios.get(rs.getInt("id"));
                if (f == null) {
                    f = new Funcionario();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setCargo(rs.getString("cargo"));
                    f.setSalario(rs.getDouble("salario"));
                    funcionarios.put(f.getId(), f);
                }

                if (rs.getObject("idItem") != null) {
                    FuncionarioItem i = new FuncionarioItem();
                    i.setId(rs.getInt("idItem"));
                    i.setIdFuncionario(f.getId());
                    i.setDescricao(rs.getString("descricao"));
                    i.setHoras(rs.getInt("horas"));
                    f.getItens().add(i);
                }
            }
        }

        return new ArrayList<>(funcionarios.values());
    }

    public Retorno excluir(int id) {
        String sqlItem = "DELETE FROM Funcionario_Item WHERE idFuncionario = ?";
        String sqlFunc = "DELETE FROM Funcionario WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps1 = con.prepareStatement(sqlItem);
             PreparedStatement ps2 = con.prepareStatement(sqlFunc)) {
            con.setAutoCommit(false);
            ps1.setInt(1, id);
            ps1.executeUpdate();
            ps2.setInt(1, id);
            ps2.executeUpdate();
            con.commit();
            return new Retorno("Funcionário excluído com sucesso!");
        } catch (Exception e) {
            return new Retorno("Erro ao excluir: " + e.getMessage());
        }
    }
}
