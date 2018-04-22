package br.com.pmp.referencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.pmp.referencia.model.Usuario;

@Repository
public class JpaUsuarioDao implements UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public boolean existeUsuario(Usuario usuario) {

		Query query = manager.createQuery("select u from usuarios u where u.login=:login and u.senha=:senha");
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());

		if (query.getSingleResult() != null) {

			return true;

		}

		return false;
	}

}
