package com.citycare.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long>{
	List<Denuncia> findByCategoriaStartingWithOrderByIdDesc(String categoria);
}
