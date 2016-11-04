package com.citycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citycare.model.Usuario;
import com.citycare.model.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@RequestMapping(value="/U_Cadastro")
	public String formUsuarioCadastro(){
		return "/usuario/Cadastro";
	}
	
	@RequestMapping(value="adicionaUsuario")
	public String adicionaUsuario(Usuario usuario){
		ur.save(usuario);
		return formUsuarioCadastro();
	}
}
