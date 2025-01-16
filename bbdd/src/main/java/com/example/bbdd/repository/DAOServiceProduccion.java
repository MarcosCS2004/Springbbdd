package com.example.bbdd.repository;

import java.util.List;

import com.example.bbdd.entity.Clasificacion;
import com.example.bbdd.entity.Produccion;

public interface DAOServiceProduccion {

	List<Produccion> listaProducciones();

	List<Clasificacion> listaCategorias();

	Clasificacion findClasificacionById(Long clasificacionId);

	void saveProduccion(Produccion produccion);

	Produccion findProduccionById(Long id);

	void deleteProduccion(Long id);

}
