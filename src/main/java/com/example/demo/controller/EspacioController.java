package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entities.Espacio;
import com.example.demo.service.EspacioService;
import com.example.demo.service.ServicioService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller 
@RequestMapping ("/espacios")
public class EspacioController {
    
    @Autowired 
    private EspacioService espacioService;
    @Autowired 
    private ServicioService servicioService;

    @GetMapping()
    public String listarEspacios(Model model) {
        model.addAttribute("espacios", espacioService.findAll());
        return "listar_espacios";
    }

    @GetMapping("/crearEspacio")
    public String crearEspacio(Model model) {
        model.addAttribute("espacio", espacioService.crearEspacio());
        model.addAttribute("servicios", servicioService.findAll());
        return "crear_espacio";
    }
    

    @GetMapping("/cambiarEstado/{id}")
    public String cambiarEstado(@PathVariable ("id") Long id) {
        espacioService.cambiarEstado(id);
        return "redirect:/espacios";
    }

    @PostMapping("/guardarEspacio")
    public String guardarEspacio(@ModelAttribute ("espacio") Espacio espacio) {
        espacioService.guardarEspacio(espacio);
        return "redirect:/espacios";
    }

    @GetMapping("/modificarEspacio/{id}")
    public String modificarEspacio(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("espacio", espacioService.findById(id));
        model.addAttribute("servicios", servicioService.findAll());
        return "crear_espacio";
    }
    
    

    
    
}
