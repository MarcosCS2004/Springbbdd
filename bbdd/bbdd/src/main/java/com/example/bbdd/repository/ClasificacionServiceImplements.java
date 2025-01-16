package com.example.bbdd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bbdd.entity.Clasificacion;

@Service
public class ClasificacionServiceImplements implements DAOService{
	
	@Autowired
	private ClasificacionRepository clasificacionRepository;

	@Override
	public void saveClasificacion(Clasificacion clasificacion) {
		clasificacionRepository.save(clasificacion);
	}

	@Override
	public List<Clasificacion> listaCategorias() {
		return clasificacionRepository.findAll();
	}

	@Override
	public void deleteClasificacion(Long id) {
		clasificacionRepository.deleteById(id);
	}

	@Override
	public Clasificacion findClasificacionById(Long id) {
		return clasificacionRepository.findById(id).orElse(null);
	}

	

}
