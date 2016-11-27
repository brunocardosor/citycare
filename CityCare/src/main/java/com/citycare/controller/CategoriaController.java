package com.citycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citycare.model.Categoria;
import com.citycare.model.CategoriaRepository;

@Controller
public class CategoriaController {
	@Autowired
	private CategoriaRepository cr;
	@Autowired
	private DenunciaController dc;
	
	
	@RequestMapping(value="/adicionaCategoria")
	public ModelAndView adicionaCategoria(Categoria categoria){
		cr.save(categoria);
		return dc.feedDenuncias();
	}
}
