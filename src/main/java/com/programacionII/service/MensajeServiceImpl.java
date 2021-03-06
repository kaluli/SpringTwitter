package com.programacionII.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programacionII.model.Mensaje;
import com.programacionII.repository.MensajeRepository;


@Service("mensajeService")
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	private MensajeRepository mensajeRepository;

	@Override
	public Mensaje findById(int id) {
		return mensajeRepository.findById(id);
	}

	@Transactional
	public Mensaje save(Mensaje mensaje) {
		mensajeRepository.save(mensaje);
		return null;
	}

	@Transactional
	public Mensaje delete(Mensaje mensaje) {
		mensajeRepository.delete(mensaje);
		return null;
	}
	
	

}
