package com.example.bbdd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produccion {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id_produccion")
	private long id_produccion;
	private Integer anio;
	@Column (name = "tipo_produccion")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "clasificacion_id", nullable = false)
	private Clasificacion clasificacion;

	public long getId_produccion() {
		return id_produccion;
	}

	public void setId_produccion(long id_produccion) {
		this.id_produccion = id_produccion;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
	
}
