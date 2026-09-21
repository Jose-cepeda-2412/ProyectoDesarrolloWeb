package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Reserva;
import com.example.demo.service.ReservaService;
import com.example.demo.service.ServicioService;
import com.example.demo.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("servicios", servicioService.findAll());
        return "crear_reserva";
    }

    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute ("reserva") Reserva reserva) {
        reserva.setHoraFin(LocalTime.of(19, 35));
        reserva.setEstado(true);
        reserva.setTotal(1.34);
        reserva.setFechaSolicitud(LocalDate.now());
        reservaService.save(reserva);
        return "redirect:/reserva";
    }
    
    
}
