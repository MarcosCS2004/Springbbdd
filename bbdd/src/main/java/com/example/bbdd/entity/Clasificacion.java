package com.example.bbdd.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_clasificacion")
    private Long id_clasificacion;
    @Column (name = "name_clasificacion")
    private String name_clasificacion;

    @OneToMany(mappedBy = "clasificacion", cascade = CascadeType.ALL)
    private List<Produccion> produccion;
    
    public Long getId_clasificacion() {
		return id_clasificacion;
	}

	public void setId_clasificacion(Long id_clasificacion) {
		this.id_clasificacion = id_clasificacion;
	}

	public String getName_clasificacion() {
		return name_clasificacion;
	}

	public void setName_clasificacion(String name_clasificacion) {
		this.name_clasificacion = name_clasificacion;
	}

	public List<Produccion> getProduccion() {
		return produccion;
	}

	public void setProduccion(List<Produccion> produccion) {
		this.produccion = produccion;
	}

	public void setNameClasificacion(String nameClasificacion) {
		this.name_clasificacion = nameClasificacion;
	}

	@Override
	public String toString() {
		return "Clasificacion [id=" + id_clasificacion + ", clasificacion=" + name_clasificacion + ", produccion=" + produccion + "]";
	}
    
}
