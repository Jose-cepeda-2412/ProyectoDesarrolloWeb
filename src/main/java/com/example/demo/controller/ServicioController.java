package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.entities.Servicio;
import com.example.demo.service.EspacioService;
import com.example.demo.service.ServicioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller 
@RequestMapping ("/servicios")
public class ServicioController {
    @Autowired 
    private ServicioService servicioService;

    @Autowired 
    private EspacioService espacioService;

    @GetMapping()
    public String listarServicios(Model model) {
        model.addAttribute("servicios", servicioService.findAll());
        return "listar_servicios";
    }

    @GetMapping("/crearServicio")
    public String crearServicio(Model model) {
        model.addAttribute("servicio", new Servicio() );
        model.addAttribute("servicio",  espacioService.findAll());
        return "crear_servicio";
    }

    @PostMapping("/guardarServicio")
    public String guardarServicio(@ModelAttribute ("servicio") Servicio servicio) {    
        servicio.setActivo(true);
        servicioService.save(servicio);
        return "redirect/:servicios";
    }
    
    

}
