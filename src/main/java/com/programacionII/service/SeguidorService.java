package com.programacionII.service;

import java.util.List;

import com.programacionII.model.Seguidor;

public interface SeguidorService {
	public Seguidor save(Seguidor usuario);
	public void delete(Seguidor usuario);
	public Seguidor findById(int idusuario, int idseguidor);
	public List<Seguidor> findByIdUsuario(int idusuario);
	public List<Seguidor> findByIdSeguidor(int seguidor);
}
