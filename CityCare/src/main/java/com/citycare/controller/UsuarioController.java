package com.citycare.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citycare.model.Usuario;
import com.citycare.model.UsuarioRepository;
import com.citycare.model.UsuarioSingleton;
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private LoginController lc;

	
	@RequestMapping(value="/U_Cadastro")
	public String formUsuarioCadastro(){
		return "/usuario/Cadastro";
	}
	
	@RequestMapping(value="adicionaUsuario")
	public String adicionaUsuario(Usuario usuario){
		ur.save(usuario);
		return "/usuario/login-screen";
	}
	
	@RequestMapping(value="desativarUsuario")
	public ModelAndView desativarUsuario(){
		Usuario usuario = UsuarioSingleton.getInstance();
		usuario.setStatus(false);
		ur.save(usuario);
		return lc.logout();
	}
	
	@RequestMapping(value="atualizarUsuario")
	public ModelAndView atualizarUsuario(Usuario usuario){
		ur.save(usuario);
		return lc.logout();
	}
}
