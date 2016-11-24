package com.citycare.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@RequestMapping(value="U_atualiza")
	public ModelAndView formUsuarioAtualiza(){
		ModelAndView mv = new ModelAndView("/usuario/AtualizaDados");
		return mv;
	}
}
