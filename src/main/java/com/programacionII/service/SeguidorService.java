package com.programacionII.service;

import com.programacionII.model.Seguidor;

public interface SeguidorService {
	public Seguidor save(Seguidor usuario);
	public void delete(Seguidor usuario);
	public Seguidor findById(int idusuario, int idseguidor);
	
}
