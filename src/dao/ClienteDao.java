package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDao {
	
	private Connection c;
	
	public ClienteDao() throws ClassNotFoundException, SQLException {
		GenericDao gdao = new GenericDao();
		c= gdao.getConnection();
	}
	
	public void inserirCliente(String nome, String email) throws SQLException {
		String sql = "insert into cliente (nome,email) values (?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);
		ps.setString(2, email);
		ps.executeUpdate();
		ps.close();
	}
	
	public List<Cliente> listarCliente() throws SQLException{
		List<Cliente> list = new ArrayList<Cliente>();
		String sql = "select id,nome,email from cliente";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Cliente cli = new Cliente();
			cli.setId(rs.getInt("id"));
			cli.setNome(rs.getString("nome"));
			cli.setEmail(rs.getString("email"));
			list.add(cli);
		}
		return list;
	}
	
	public void atualizarCliente(Cliente cli) throws SQLException {
		String sql = "update cliente set nome=?, email=? where id=?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cli.getNome());
		ps.setString(2, cli.getEmail());
		ps.setInt(3, cli.getId());
		ps.executeUpdate();
		ps.close();
	}
	
	public void excluirCliente(int id) throws SQLException {
		String sql = "delete from cliente where id=?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

}
