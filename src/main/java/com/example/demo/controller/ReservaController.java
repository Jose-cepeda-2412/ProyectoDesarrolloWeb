package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entities.Reserva;
import com.example.demo.service.ReservaService;
import com.example.demo.service.ServicioService;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller 
@RequestMapping ("/reserva")
public class ReservaController {
    
    
    @Autowired 
    private ReservaService reservaService;
    @Autowired 
    private UsuarioService usuarioService;
    @Autowired 
    private ServicioService servicioService;


    @GetMapping()
    public String listarReserva(Model model) {
        model.addAttribute("reservas", reservaService.findAll());
        return "listar_reservas";
    }

    @GetMapping("/crearReserva")
    public String crearReserva(Model model) {
        model.addAttribute("reserva", reservaService.crearReserva());
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("servicios", servicioService.findAll());
        return "crear_reserva";
    }

    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute ("reserva") Reserva reserva) {
        reservaService.guardarReserva(reserva);
        return "redirect:/reserva";
    }

    @GetMapping("/cambiarEstado/{id}")
    public String cambiarEstadoReserva(@PathVariable  ("id") Long id) {
        reservaService.cambiarEstado(id);
        return "redirect:/reserva";
    }

    @GetMapping("/modificarReserva/{id}")
    public String modificarReserva(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("reserva", reservaService.findById(id));
        model.addAttribute("servicios", servicioService.findAll());
        model.addAttribute("usuarios", usuarioService.findAll());
        return "crear_reserva";
    }
    
    
    
    
}
