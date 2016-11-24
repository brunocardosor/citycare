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
import com.citycare.model.Usuario;
import com.citycare.model.UsuarioSingleton;

@Controller
public class DenunciaController {
	@Autowired //injeção de dependencia 
	private DenunciaRepository dr;
	
	@Autowired
	private CategoriaRepository cr;
	
	@RequestMapping(value="feed")
	public ModelAndView feedDenuncias(){
		Usuario usuario = UsuarioSingleton.getInstance();
		List<Categoria> categoria = cr.findAll();
		List<Denuncia> denuncia = dr.findAllByOrderByIdDesc();
		List<Denuncia> qntdDenuncia = dr.findByUsuarioOrderByIdDesc(usuario);
		ModelAndView mv = new ModelAndView("/denuncia/feed-denuncias");
		mv.addObject("nomeUsuario", usuario.getNome());
		mv.addObject("qntdDenuncias", qntdDenuncia.size());
		mv.addObject("todosValoresCategoria",categoria);
		mv.addObject("todosValoresDenuncia", denuncia);
		return mv;	
	}
		
		@RequestMapping(value="profile")
		public ModelAndView profileUsuario(Usuario usuario){
		usuario = UsuarioSingleton.getInstance();
		List<Denuncia> denuncia = dr.findByUsuarioOrderByIdDesc(usuario);
		ModelAndView mv = new ModelAndView("/usuario/profile");
		mv.addObject("nomeUsuario", usuario.getNome());
		mv.addObject("qntdDenuncias", denuncia.size());
		mv.addObject("todosValoresDenuncia", denuncia);
		return mv;
	}
	
	@RequestMapping(value="adicionaDenuncia")
	public ModelAndView adicionaDenuncia(Denuncia denuncia){
		denuncia.setUsuario(UsuarioSingleton.getInstance());
		dr.save(denuncia);
		return feedDenuncias();
	}
	
	@RequestMapping(value="deletaDenuncia")
	public ModelAndView deletaDenuncia(Denuncia denuncia){
		dr.delete(denuncia);
		return null;
		
	}
	
	@RequestMapping(value="pesquisar")
	public ModelAndView pesquisar(String descricao){
		List<Categoria> categoria = cr.findByDescricaoContaining(descricao);
		Categoria categoriaPesq = new Categoria();
		categoriaPesq.setDescricao(categoria.get(0).getDescricao());
		categoriaPesq.setId(categoria.get(0).getId());
		Usuario usuario = UsuarioSingleton.getInstance();
		List<Denuncia> denuncia = dr.findByCategoriaOrderByIdDesc(categoriaPesq);
		List<Denuncia> qntdDenuncia = dr.findByUsuarioOrderByIdDesc(usuario);
		ModelAndView mv = new ModelAndView("/denuncia/pesquisa");
		mv.addObject("nomeUsuario", usuario.getNome());
		mv.addObject("qntdDenuncias", qntdDenuncia.size());
		mv.addObject("resultadoPesquisa", denuncia);
		return mv;
	}
}
