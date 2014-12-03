package com.programacionII.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.programacionII.model.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select s from Usuario s where s.usuario = :usuario")
	Usuario findByUserName(@Param("usuario") String usuario);

	@Query("select s from Usuario s where s.nombre like %:usuario% or s.apellido like %:usuario% or s.usuario like %:usuario%")
	List<Usuario> findbyName(@Param("usuario") String usuario);
	
}
