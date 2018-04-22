package br.com.pmp.referencia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pmp.referencia.dao.UsuarioDao;
import br.com.pmp.referencia.model.Usuario;

@Transactional
@Controller
public class LoginController {
	
	//private JdbcUsuarioDao dao;
	@Autowired
	@Qualifier("jpaUsuarioDao")
	private UsuarioDao dao;
	
	
	//public LoginController(JdbcUsuarioDao dao) {
		
	//	this.dao = dao;
		
	//}
	
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
	
	@RequestMapping("/efetuarLogout")
	public String efetuarLogout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}

}
