package br.com.pmp.referencia.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.pmp.referencia.model.Meta;

@Repository
public class JpaMetaDao implements MetaDao{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Meta meta) {
		
		manager.persist(meta);
		
	}
	
	@Override
	public void alterar(Meta meta) {
		
		manager.merge(meta);
		
	}
	
	@Override
	public List<Meta> listar() {
		
		return manager.createQuery("select t from metas t").getResultList();
	}
	
	@Override
	public Meta buscarPorid(Long id) {
		
		return manager.find(Meta.class, id);
		
	}
	
	@Override
	public void remover(Long id) {
		
		Meta meta = buscarPorid(id);
		manager.remove(meta);
		
	}
	
	@Override
	public void finalizar(Long id) {
		
		Meta meta = buscarPorid(id);
		meta.setFinalizado(true);
		meta.setDataFim(Calendar.getInstance());
		
		manager.merge(meta);
		
	}
	
	@Override
	public void iniciar(Long id) {
		
		Meta meta = buscarPorid(id);
		meta.setDataInicio(Calendar.getInstance());
		
		manager.merge(meta);
		
	}

}
