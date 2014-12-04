package com.programacionII.service;


import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Mensaje save(Mensaje mensaje) {
		mensajeRepository.save(mensaje);
		return null;
	}
	
	

}
