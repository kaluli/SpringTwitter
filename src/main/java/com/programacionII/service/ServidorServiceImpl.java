package com.programacionII.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programacionII.model.Seguidor;
import com.programacionII.repository.SeguidorRepository;


@Service("seguidorService")
public class ServidorServiceImpl implements SeguidorService {

	@Autowired
	private SeguidorRepository seguidorRepository;
	
	@Transactional
	public Seguidor save(Seguidor seguidor) {
		return seguidorRepository.save(seguidor);
	}

	@Override
	public void delete(Seguidor seguidor) {
		seguidorRepository.delete(seguidor);
	}
	
	@Override
	public Seguidor findById(int idusuario, int idseguidor) {
		return seguidorRepository.findbyId(idusuario, idseguidor);
	}

	@Override
	public List<Seguidor> findByIdUsuario(int idusuario) {
		return seguidorRepository.findbyIdUsuario(idusuario);
	}

	@Override
	public List<Seguidor> findByIdSeguidor(int idseguidor) {
		return seguidorRepository.findbyIdSeguidor(idseguidor);
	}

	
}
