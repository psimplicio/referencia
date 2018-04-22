package br.com.pmp.referencia.dao;

import java.util.List;

import br.com.pmp.referencia.model.Meta;

public interface MetaDao {
	
	public void alterar(Meta meta);
	public Meta buscarPorid(Long id);
	public void finalizar(Long id);
	public void iniciar(Long id);
	public void inserir(Meta meta);
	public List<Meta> listar();
	public void remover(Long id);

}
