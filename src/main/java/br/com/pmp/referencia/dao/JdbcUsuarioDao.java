package br.com.pmp.referencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.pmp.referencia.model.Usuario;

@Repository
public class JdbcUsuarioDao implements UsuarioDao{
	
	private Connection connetion;
	
	@Autowired
	public JdbcUsuarioDao(BasicDataSource dataSource) {
		
		try {
			this.connetion = dataSource.getConnection();
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	public boolean existeUsuario(Usuario usuario) {
		
		String sql = "select * from usuarios where login = ? and senha = ?";
		PreparedStatement stmt;
		
		try {
			
			stmt = connetion.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				return true;
			}
			
			return false;
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
		
	}

}
