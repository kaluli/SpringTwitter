package com.programacionII.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.programacionII.model.Seguidor;

@Repository("seguidorRepository")
public interface SeguidorRepository extends JpaRepository<Seguidor, Long> {
	
	@Query("select s from Seguidor s where s.idusuario = :idusuario and s.idseguidor = :idseguidor")	
	public Seguidor findbyId(@Param("idusuario") int idusuario,@Param("idseguidor") int idseguidor);
	
	@Query("select s from Seguidor s where s.idusuario = :idusuario")	
	public List<Seguidor> findbyIdUsuario(@Param("idusuario") int idusuario);

	@Query("select s from Seguidor s where s.idseguidor = :idseguidor")		
	public List<Seguidor> findbyIdSeguidor(@Param("idseguidor") int idseguidor);
	
}
