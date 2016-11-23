package com.citycare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citycare.model.LoginRepository;
import com.citycare.model.Usuario;
import com.citycare.model.UsuarioSingleton;

@Controller
public class LoginController {
	
	@Autowired
	private LoginRepository lr;
	@Autowired
	private DenunciaController dc;
	
	@RequestMapping(value="login")
	public String loginScreen(){
		return "/usuario/login-screen";
	}
	
	
	@RequestMapping(value="efetuaLogin")
	public ModelAndView login(String email, String senha){
		//busca no banco através do email e senha inseridos na página
		List<Usuario> usuario = lr.findByEmailAndSenha(email, senha);
		//testa valores da página com as do banco

			if(usuario.size() > 0 && usuario.get(0).getEmail().equals(email) && usuario.get(0).getSenha().equals(senha)){
			//verifica se usuário está ativo
				if(usuario.get(0).isStatus() == true){
					Usuario user = usuario.get(0);
					UsuarioSingleton.setInstance(user);
					ModelAndView mv = new ModelAndView();
					mv.addObject("NomeUsuario", user);
					return dc.feedDenuncias();
			
				} else {
				//tela com aviso de conta desativada
					ModelAndView mv = new ModelAndView("/usuario/login-screen");
					mv.addObject("mensagem","Conta Desativada");
					return mv;
				}
			} else {
			//tela com aviso de 
			ModelAndView mv = new ModelAndView("/usuario/login-screen");
			mv.addObject("mensagem","Senha ou Login incorretos");
			return mv;
		}
	}
}
