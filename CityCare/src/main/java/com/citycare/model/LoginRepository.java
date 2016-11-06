package com.citycare.model;


import java.util.List;

import org.springframework.data.repository.Repository;

public interface LoginRepository extends Repository<Usuario, Long>{
	public List<Usuario> findByEmailAndSenha(String email, String senha);
	
	}