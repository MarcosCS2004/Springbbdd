package com.example.bbdd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.bbdd.entity.Clasificacion;
import com.example.bbdd.repository.DAOService;

@Controller
public class ClasificacionController {
	
	@Autowired
	DAOService daoS;
	
	@GetMapping("/home")
	public String inicoClasificacion() {
		return "index";
	}
	
	@GetMapping("/verClasificacion")
	public String recogerCategorias(Model model) {
		List<Clasificacion> clasificacionList = daoS.listaCategorias();
		model.addAttribute("listaclasificacion",clasificacionList);
		return "verClasificacion";
	}

	@PostMapping("/guardar")
	public String guardarCategoria(@RequestParam("name_clasificacion") String nameClasificacion) {
		Clasificacion clasificacion = new Clasificacion();
		clasificacion.setNameClasificacion(nameClasificacion);
		daoS.saveClasificacion(clasificacion);
		return "redirect:/verClasificacion";
	}
	
	@PostMapping("/borrar")
	public String borrarCategoria(@RequestParam Long id) {
	    daoS.deleteClasificacion(id);  
	    return "redirect:/verClasificacion";  
	}
	
	@GetMapping("/editar/{id}")
	public String editarCategoria(@PathVariable Long id, Model model) {
	    Clasificacion clasificacion = daoS.findClasificacionById(id);
	    model.addAttribute("clasificacion", clasificacion);
	    return "actualizar";
	}

	@PostMapping("/editar")
	public String actualizarCategoria(@RequestParam(required = false) Long id, @RequestParam String name_clasificacion, Model model) {
	    if (id == null) {
	        model.addAttribute("error", "El ID no puede ser nulo.");
	        return "error";
	    }
	    
	    Clasificacion clasificacionExistente = daoS.findClasificacionById(id);
	    if (clasificacionExistente != null) {
	        clasificacionExistente.setNameClasificacion(name_clasificacion);
	        daoS.saveClasificacion(clasificacionExistente);
	    }
	    return "redirect:/verClasificacion";
	}


}
