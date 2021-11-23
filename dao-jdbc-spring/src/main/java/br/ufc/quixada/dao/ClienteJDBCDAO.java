package br.ufc.quixada.dao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
//classe que sirva para ser injetada - onde tem o autowired
//Tudo fora do br.ufc.quixada ele vai procurar para injetar
@Repository
public class ClienteJDBCDAO implements  ClienteDAO{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	public ClienteJDBCDAO() { }
	
	public void save(Cliente entity) {
		String insert_sql = "insert into clientes (cpf, nome, fone, renda) values (:cpf, :nome, :fone, :renda)";
		String update_sql = "update clientes set cpf = :cpf, nome = :nome, fone = :fone, renda = :renda where id = :id";
		MapSqlParameterSource parameter = new MapSqlParameterSource()
				.addValue("cpf", entity.getCpf())
				.addValue("nome", entity.getNome())
				.addValue("fone", entity.getFone())
				.addValue("renda", entity.getRenda());
		if (entity.getId() == 0)
			jdbcTemplate.update(insert_sql, parameter);
		 else {
			parameter.addValue("id", entity.getId());
			jdbcTemplate.update(update_sql, parameter);
		}
	}

	public void delete(int id) {
		String sql = "delete from clientes where id = :id";
		MapSqlParameterSource named = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql, named);
	}

	public Cliente find(int id) {
		String sql = "select id, cpf, nome, fone, renda from clientes where id = :idd";
		SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("idd", id);
		return jdbcTemplate.queryForObject(sql, namedParameter, (rs, rowNum) -> map(rs));
	}

	private Cliente map(ResultSet rs) throws SQLException {
		Cliente cl = new Cliente();
		cl.setId(rs.getInt("id"));
		cl.setCpf(rs.getString("cpf"));
		cl.setNome(rs.getString("nome"));
		cl.setFone(rs.getString("fone"));
		cl.setRenda(rs.getBigDecimal("renda").doubleValue());
		return cl;
	}

	public List<Cliente> find() {
		String sql = "select id, cpf, nome, fone, renda from clientes";
		return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
	}

	public Cliente findByCpf(String cpf) {
		String sql = "select id, cpf, nome, fone, renda from clientes where cpf = :cpff";
		SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("cpff", cpf);
		List<Cliente> resultado =  jdbcTemplate.query(sql, namedParameter, (rs, rowNum) -> map(rs));
		return resultado.get(0);
	}

	public List<Cliente> findByNome(String str) {
		String sql = "select id, cpf, nome, fone, renda from clientes where upper(nome) like :strr";
		SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("strr", "%" + str.toUpperCase() + "%");
		return jdbcTemplate.query(sql, namedParameter, (rs, rowNum) -> map(rs));
	}
	
}
