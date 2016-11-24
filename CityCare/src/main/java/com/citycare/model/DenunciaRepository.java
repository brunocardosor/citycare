package com.citycare.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long>{
	public List<Denuncia> findAllByOrderByIdDesc();
	public List<Denuncia> findByUsuarioOrderByIdDesc(Usuario usuario);
	public List<Denuncia> findByCategoriaOrderByIdDesc(Categoria categoria);
}