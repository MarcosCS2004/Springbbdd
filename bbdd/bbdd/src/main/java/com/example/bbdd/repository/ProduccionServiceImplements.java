package com.example.bbdd.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bbdd.entity.Clasificacion;
import com.example.bbdd.entity.Produccion;

@Service
public class ProduccionServiceImplements implements DAOServiceProduccion{
	
	@Autowired
	ProduccionRepository produccionRepository;
	
	@Autowired
	ClasificacionRepository clasificacionRepository;

	@Override
	public List<Produccion> listaProducciones() {
		List<Produccion> produccionList = new ArrayList<>();
		produccionList = produccionRepository.findAll();
		return produccionList;
	}

	@Override
	public List<Clasificacion> listaCategorias() {
		List<Clasificacion> clasificacionList = new ArrayList<>();
		clasificacionList = clasificacionRepository.findAll();
		return clasificacionList;
	}

	@Override
	public Clasificacion findClasificacionById(Long clasificacionId) {
		return clasificacionRepository.findById(clasificacionId).orElse(null);
	}

	@Override
	public void saveProduccion(Produccion produccion) {
		produccionRepository.save(produccion);
	}

	@Override
	public Produccion findProduccionById(Long id) {
		return produccionRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteProduccion(Long id) {
		produccionRepository.deleteById(id);
	}

}
