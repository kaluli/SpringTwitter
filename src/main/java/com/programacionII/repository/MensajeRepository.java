package com.programacionII.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.programacionII.model.Mensaje;

@Repository("mensajeRepository")
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

	@Query("select s from Mensaje s where s.id = :id")
	public Mensaje findById(@Param("id") int id);

	
	
}
