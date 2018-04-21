package br.com.pmp.referencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;

import br.com.pmp.referencia.model.Meta;

@Repository
public class JdbcMetaDao {
	
	private Connection dao;
	
	public JdbcMetaDao(BasicDataSource dataSource) {
		
		try {
			
			this.dao = dataSource.getConnection();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
	} 
	
	public void inserir(Meta meta) {
		
		String sql = "insert into metas (meta, autorMeta) values (?,?)";
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.prepareStatement(sql);
			stmt.setString(1, meta.getMeta());
			stmt.setString(2, meta.getAutorMeta());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
			
	}
	
	public List<Meta> listar(){
		
		String sql = "select * from metas";
		PreparedStatement stmt;
		List<Meta> metas = new ArrayList<Meta>();
		
		try {
			
			stmt = dao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				metas.add(popularMeta(rs));
				
			}
			
			stmt.close();
			rs.close();
			
			return metas;
			
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}
	
	public Meta popularMeta(ResultSet rs) {
		
		Meta meta = new Meta();
	
		try {
			
			meta.setId(rs.getLong(1));
			meta.setMeta(rs.getString(2));
			meta.setAutorMeta(rs.getString(3));
			
			Date dataInicioSql = rs.getDate(4);
			if(dataInicioSql != null) {
				
				Calendar dataInicio = Calendar.getInstance();
				dataInicio.setTime(dataInicioSql);
				meta.setDataInicio(dataInicio);
			}
			
			Date dataFimSql = rs.getDate(5);
			if(dataFimSql != null) {
				
				Calendar dataFim = Calendar.getInstance();
				dataFim.setTime(dataFimSql);
				meta.setDataFim(dataFim);
				
			}
			
			meta.setFinalizado(rs.getBoolean(6));
			
			return meta;
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
	}
		

		
		
	

}
