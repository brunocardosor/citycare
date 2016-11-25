package com.citycare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired // injeção de dependencia
	private DenunciaRepository dr;

	@Autowired
	private CategoriaRepository cr;

	@RequestMapping(value = "feed")
	public ModelAndView feedDenuncias() {
		Usuario usuario = UsuarioSingleton.getInstance();
		List<Categoria> categoria = cr.findAll();
		List<Denuncia> denuncia = dr.findAllByOrderByIdDesc();
		List<Denuncia> qntdDenuncia = dr.findByUsuarioOrderByIdDesc(usuario);
		ModelAndView mv = new ModelAndView("/denuncia/feed-denuncias");
		mv.addObject("nomeUsuario", usuario.getNome());
		mv.addObject("qntdDenuncias", qntdDenuncia.size());
		mv.addObject("todosValoresCategoria", categoria);
		mv.addObject("todosValoresDenuncia", denuncia);
		return mv;
	}

	@RequestMapping(value = "profile")
	public ModelAndView profileUsuario(Usuario usuario) {
		usuario = UsuarioSingleton.getInstance();
		List<Denuncia> denuncia = dr.findByUsuarioOrderByIdDesc(usuario);
		ModelAndView mv = new ModelAndView("/usuario/profile");
		mv.addObject("nomeUsuario", usuario.getNome());
		mv.addObject("qntdDenuncias", denuncia.size());
		mv.addObject("todosValoresDenuncia", denuncia);
		return mv;
	}

	@RequestMapping(value = "adicionaDenuncia")
	public ModelAndView adicionaDenuncia(Denuncia denuncia) {
		denuncia.setUsuario(UsuarioSingleton.getInstance());
		dr.save(denuncia);
		return feedDenuncias();
	}

	@RequestMapping(value = "deletaDenuncia/{codigo}")
	public ModelAndView deletaDenuncia(@PathVariable("codigo") Denuncia denuncia) {
		dr.delete(denuncia);
		Usuario usuario = UsuarioSingleton.getInstance();
		return profileUsuario(usuario);
	}

	@RequestMapping(value = "pesquisar")
	public ModelAndView pesquisar(String descricao) {
		ModelAndView mv = new ModelAndView("/denuncia/pesquisa");
		List<Categoria> categoria = cr.findByDescricaoContaining(descricao);
		ArrayList<Denuncia> todasDenuncias = new ArrayList<Denuncia>();
		for (Categoria c : categoria) {
			List<Denuncia> denuncia = dr.findByCategoriaOrderByIdDesc(c);
			for (Denuncia d : denuncia) {
				todasDenuncias.add(d);
			}
		}

		Usuario usuario = UsuarioSingleton.getInstance();
		List<Denuncia> qntdDenuncia = dr.findByUsuarioOrderByIdDesc(usuario);
		mv.addObject("resultadoPesquisa", todasDenuncias);
		mv.addObject("nomeUsuario", usuario.getNome());
		mv.addObject("qntdDenuncias", qntdDenuncia.size());
		return mv;
	}
}
