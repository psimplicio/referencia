package br.com.pmp.referencia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pmp.referencia.dao.JdbcMetaDao;
import br.com.pmp.referencia.model.Meta;
import br.com.pmp.referencia.model.Usuario;

@Controller
public class MetaController {
	
	private JdbcMetaDao dao;
	
	@Autowired
	public MetaController(JdbcMetaDao dao) {
		
		this.dao = dao;
		
	}
	
	@RequestMapping("inserirMetaForm")
	public String inserirMetaForm() {
		
		return "/inserirMetaForm";
	}
	
	@RequestMapping("inserirMeta")
	public String inserirMeta(Meta meta, HttpSession session) {
		
		Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
		meta.setAutorMeta(usuario.getLogin());
		dao.inserir(meta);
		
		return "redirect:inserirMetaForm";
		
	}

}
