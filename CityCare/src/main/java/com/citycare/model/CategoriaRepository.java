package com.citycare.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria> findByDescricao(String descricao);
}
