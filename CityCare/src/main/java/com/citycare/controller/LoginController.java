package com.citycare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citycare.model.LoginRepository;
import com.citycare.model.Usuario;

@Controller
public class LoginController {
	@Autowired
	private LoginRepository lr;
	
	@RequestMapping(value="login")
	public String loginScreen(){
		return "/usuario/login-screen";
	}
	
	@RequestMapping(value="efetuaLogin")
	public ModelAndView login(String email, String senha){
		List<Usuario> user = lr.findByEmailAndSenha(email, senha);
		if(user.size() == 1){
		ModelAndView mv = new ModelAndView("/denuncia/Cadastro");
		return mv;
		} else {
			ModelAndView mv = new ModelAndView("/usuario/login-screen");
			mv.addObject("mensagem","Senha ou Login incorretos");
			return mv;
		}
	}
}
