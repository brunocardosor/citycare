package com.citycare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citycare.model.Denuncia;
import com.citycare.model.DenunciaRepository;
import com.citycare.model.Usuario;
import com.citycare.model.UsuarioRepository;
import com.citycare.model.UsuarioSingleton;
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private DenunciaRepository dr;
	
	@RequestMapping(value="/U_Cadastro")
	public String formUsuarioCadastro(){
		return "/usuario/Cadastro";
	}
	
	@RequestMapping(value="adicionaUsuario")
	public String adicionaUsuario(Usuario usuario){
		ur.save(usuario);
		return formUsuarioCadastro();
	}
	
	@RequestMapping(value="profile")
	public ModelAndView profileUsuario(Usuario usuario){
		usuario = UsuarioSingleton.getInstance();
		List<Denuncia> denuncia = dr.findByUsuarioOrderByIdDesc(usuario);
		ModelAndView mv = new ModelAndView("/usuario/profile");
		mv.addObject("todosValoresDenuncia", denuncia);
		return mv;
	}
	
	@RequestMapping(value="U_atualiza")
	public ModelAndView formUsuarioAtualiza(){
		ModelAndView mv = new ModelAndView("/usuario/AtualizaDados");
		return mv;
	}
}
