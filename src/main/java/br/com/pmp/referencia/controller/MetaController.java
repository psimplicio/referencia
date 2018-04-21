package br.com.pmp.referencia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("voltarMenu")
	public ModelAndView voltarMenu() {
		
		ModelAndView modelAndView = new ModelAndView("menu");
		
		return modelAndView;
	}
	
	@RequestMapping("inserirMetaForm")
	public ModelAndView inserirMetaForm() {
		
		ModelAndView modelAndView = new ModelAndView("inserirMetaForm");
		
		return modelAndView;
		
	}
	
	@RequestMapping("inserirMeta")
	public ModelAndView inserirMeta(Meta meta, HttpSession session) {
		
		Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
		meta.setAutorMeta(usuario.getLogin());
		dao.inserir(meta);
		ModelAndView modelAndView = new ModelAndView("redirect:inserirMetaForm");
		
		return modelAndView;
		
	}
	
	@RequestMapping("listarMetas")
	public ModelAndView listarMetasForm() {
		
		ModelAndView modelAndView = new ModelAndView("listarMetasForm");
		modelAndView.addObject("metas", dao.listar());
		
		return modelAndView;
		
	}
	
	@RequestMapping("alterarMetaForm")
	public ModelAndView alterarMetaForm(Long id) {
		
		ModelAndView mav = new ModelAndView("alterarMetaForm");
		mav.addObject("meta", dao.buscarPorid(id));
		
		return mav;
		
	}
	
	@RequestMapping("removerMeta")
	public ModelAndView removerMeta(Long id) {
		
		dao.remover(id);
		ModelAndView mav = new ModelAndView("redirect:listarMetas");
		
		return mav;
		
	}

}
