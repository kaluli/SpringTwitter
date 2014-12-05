package com.programacionII.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.programacionII.model.Mensaje;


@Repository("mensajeRepository")
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

	
	
}
