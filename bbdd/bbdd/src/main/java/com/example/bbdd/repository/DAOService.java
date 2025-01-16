package com.example.bbdd.repository;

import java.util.List;

import com.example.bbdd.entity.Clasificacion;

public interface DAOService{
	
	//Definiciones de Clasificacion
	void saveClasificacion(Clasificacion clasificacion);
	List <Clasificacion> listaCategorias();
	
	void deleteClasificacion(Long id);
	Clasificacion findClasificacionById(Long id);

}
