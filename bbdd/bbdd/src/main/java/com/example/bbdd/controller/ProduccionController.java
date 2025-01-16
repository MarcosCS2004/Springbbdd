package com.example.bbdd.controller;

import com.example.bbdd.entity.Produccion;
import com.example.bbdd.entity.Clasificacion;
import com.example.bbdd.repository.DAOServiceProduccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProduccionController {

    @Autowired
    private DAOServiceProduccion daoService;

    @GetMapping("/verProduccion")
    public String verProduccion(Model model) {
        List<Produccion> produccionList = daoService.listaProducciones();
        model.addAttribute("listaproduccion", produccionList);

        List<Clasificacion> clasificacionList = daoService.listaCategorias();
        model.addAttribute("listaclasificacion", clasificacionList);

        return "verProduccion";
    }


    @PostMapping("/guardarProduccion")
    public String guardarProduccion(@RequestParam Integer anio,
                                     @RequestParam String tipo,
                                     @RequestParam Long clasificacionId) {
        Produccion produccion = new Produccion();
        Clasificacion clasificacion = daoService.findClasificacionById(clasificacionId);

        produccion.setAnio(anio);
        produccion.setTipo(tipo);
        produccion.setClasificacion(clasificacion);

        daoService.saveProduccion(produccion);

        return "redirect:/verProduccion";
    }

    @GetMapping("/editarProduccion/{id}")
    public String editarProduccion(@PathVariable Long id, Model model) {
        Produccion produccion = daoService.findProduccionById(id);
        List<Clasificacion> clasificacionList = daoService.listaCategorias();

        model.addAttribute("produccion", produccion);
        model.addAttribute("listaclasificacion", clasificacionList);

        return "actualizarProduccion";
    }

    @PostMapping("/editarProduccion")
    public String actualizarProduccion(@RequestParam Long id,
                                       @RequestParam Integer anio,
                                       @RequestParam String tipo,
                                       @RequestParam Long clasificacionId) {
        Produccion produccion = daoService.findProduccionById(id);
        Clasificacion clasificacion = daoService.findClasificacionById(clasificacionId);

        produccion.setAnio(anio);
        produccion.setTipo(tipo);
        produccion.setClasificacion(clasificacion);

        daoService.saveProduccion(produccion);

        return "redirect:/verProducciones";
    }

    @PostMapping("/borrarProduccion")
    public String borrarProduccion(@RequestParam Long id) {
        daoService.deleteProduccion(id);
        return "redirect:/verProducciones";
    }
}
