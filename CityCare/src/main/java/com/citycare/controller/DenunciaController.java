package com.citycare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citycare.model.Categoria;
import com.citycare.model.CategoriaRepository;
import com.citycare.model.Denuncia;
import com.citycare.model.DenunciaRepository;
import com.citycare.model.UsuarioSingleton;

@Controller
public class DenunciaController {
	@Autowired //injeção de dependencia 
	private CategoriaRepository cr;
	@Autowired
	private DenunciaRepository dr;
	
	
	
	@RequestMapping(value="/D_Cadastro")
	public ModelAndView formDenunciaCadastro(){
		List<Categoria> categoria = cr.findAll();
		ModelAndView mv = new ModelAndView("/denuncia/Cadastro");
		mv.addObject("todosValoresCategoria",categoria);
		return mv;
	}
	
	@RequestMapping(value="adicionaDenuncia")
	public ModelAndView adicionaDenuncia(Denuncia denuncia){
		denuncia.setUsuario(UsuarioSingleton.getInstance());
		dr.save(denuncia);
		return formDenunciaCadastro();
	}
	
	@RequestMapping(value="deletaDenuncia")
	public ModelAndView deletaDenuncia(Denuncia denuncia){
		dr.delete(denuncia);
		return null;
		
	}
	
	@RequestMapping(value="pesquisa")
	public ModelAndView pesquisar(String categoria){
		ModelAndView mv = new ModelAndView();
		List<Denuncia> denuncia = dr.findByCategoriaStartingWithOrderByIdDesc(categoria);
		mv.addObject("resultadoPesquisa", denuncia);
		return null;
	}
}
