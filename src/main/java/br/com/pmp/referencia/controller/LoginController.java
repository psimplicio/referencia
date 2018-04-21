package br.com.pmp.referencia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pmp.referencia.dao.JdbcUsuarioDao;
import br.com.pmp.referencia.model.Usuario;

@Controller
public class LoginController {
	
	private JdbcUsuarioDao dao;
	
	@Autowired
	public LoginController(JdbcUsuarioDao dao) {
		
		this.dao = dao;
		
	}
	
	@GetMapping("/")
	public String login() {
		
		return "loginForm";
	}
	
	@RequestMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session) {
		
		if(dao.existeUsuario(usuario)) {
			
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
			
		}
		
		return "redirect:/";
		
	}

}
