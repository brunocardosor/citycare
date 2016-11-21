package com.citycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citycare.model.Categoria;
import com.citycare.model.CategoriaRepository;

@Controller
public class CategoriaController {
	@Autowired
	private CategoriaRepository cr;
	
	@RequestMapping(value="/C_Cadastro")
	public String formCategoriaCadastro(){
		return "/categoria/Cadastro";
	}
	
	
	
	@RequestMapping(value="/adicionaCateg $$$oria")
	public String adicionaCategoria(Categoria categoria){
		cr.save(categoria);
		return formCategoriaCadastro();
	}
}
