package com.programacionII.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.programacionII.model.Seguidor;

@Repository("seguidorRepository")
public interface SeguidorRepository extends JpaRepository<Seguidor, Long> {
	
	@Query("select s from Seguidor s where s.idusuario = :idusuario and s.idseguidor = :idseguidor")	
	public Seguidor findbyId(@Param("idusuario") int idusuario,@Param("idseguidor") int idseguidor);
	
}
