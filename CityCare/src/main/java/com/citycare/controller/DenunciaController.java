package com.citycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citycare.model.Denuncia;
import com.citycare.model.DenunciaRepository;

@Controller
public class DenunciaController {
	@Autowired
	private DenunciaRepository dr;
	
	@RequestMapping(value="/D_Cadastro")
	public String formDenunciaCadastro(){
		return "/denuncia/Cadastro";
	}
	
	@RequestMapping(value="adicionaDenuncia")
	public String adicionaDenuncia(Denuncia denuncia){
		dr.save(denuncia);
		return null;
	}
}
