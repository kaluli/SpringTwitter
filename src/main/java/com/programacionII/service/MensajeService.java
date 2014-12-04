package com.programacionII.service;

import com.programacionII.model.Mensaje;

public interface MensajeService {	
	public Mensaje findById(int id);
	public Mensaje save(Mensaje mensaje);
}
