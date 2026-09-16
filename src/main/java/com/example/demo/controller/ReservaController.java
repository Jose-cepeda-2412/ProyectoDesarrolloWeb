package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ReservaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
@RequestMapping ("/reservas")
public class ReservaController {
    
    @Autowired 
    private ReservaService reservaService;


    @GetMapping()
    public String listarReserva(Model model) {
        model.addAttribute("reservas", reservaService.findAll());
        return "listar_reservas";
    }

    @GetMapping("/crearReserva")
    public String crearReserva() {
        return "crear_reserva";
    }
    
}
