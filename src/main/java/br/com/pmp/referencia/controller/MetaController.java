package br.com.pmp.referencia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView alterarMetaForm(@RequestParam("id") Long id) {
		
		ModelAndView mav = new ModelAndView("alterarMetaForm");
		mav.addObject("meta", dao.buscarPorid(id));
		
		return mav;
		
	}
	
	@RequestMapping("removerMeta")
	public ModelAndView removerMeta(@RequestParam("id") Long id) {
		
		dao.remover(id);
		ModelAndView mav = new ModelAndView("redirect:listarMetas");
		
		return mav;
		
	}
	
	@RequestMapping("alterarMeta")
	public ModelAndView alterarMeta(Meta meta) {
		
		dao.alterar(meta);
		ModelAndView mav = new ModelAndView("redirect:listarMetas");
		
		return mav;	
	}
	
	@RequestMapping("finalizarAgora")
	public ModelAndView finalizarAgora(@RequestParam("id") Long id) {
		
		dao.finalizar(id);
		ModelAndView mav = new ModelAndView("metaFinalizada");
		mav.addObject("meta", dao.buscarPorid(id));
		
		return mav;
		
	}
	
	@RequestMapping("iniciarAgora")
	public ModelAndView iniciarAgora(@RequestParam("id") Long id) {
		
		dao.iniciar(id);
		ModelAndView mav = new ModelAndView("metaIniciada");
		mav.addObject("meta", dao.buscarPorid(id));
		
		return mav;
		
	}

}
