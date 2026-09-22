package com.example.demo.controller;

import com.example.demo.repository.ReservaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entities.Reserva;
import com.example.demo.entities.Servicio;
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
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("servicios", servicioService.findAll());
        return "crear_reserva";
    }

    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute ("reserva") Reserva reserva) {
        
        if (reserva.getId() != null) {
            Reserva reservaDatosAnteriores = reservaService.findById(reserva.getId());
            //si el usuario no cambio la Fecha y la Hora de inicio queda igual a como estaba 
            if (reserva.getFecha() == null) {
                reserva.setFecha(reservaDatosAnteriores.getFecha());
            }
            if (reserva.getHoraInicio() == null) {
                reserva.setHoraInicio(reservaDatosAnteriores.getHoraInicio());
            }
            reserva.setHoraFin(reservaDatosAnteriores.getHoraFin());
            reserva.setFechaSolicitud(reservaDatosAnteriores.getFechaSolicitud());
            reserva.setEstado(reservaDatosAnteriores.getEstado());
        }else{
            reserva.setHoraFin(LocalTime.of(19, 35));
            reserva.setEstado(true);
            reserva.setFechaSolicitud(LocalDate.now());
        }

        Double totalPagar = 0.0;
        for (Servicio servicio : reserva.getServicio()) {
            totalPagar += servicio.getPrecio();
        }
        reserva.setTotal(totalPagar);
        reservaService.save(reserva);
        return "redirect:/reserva";
    }

    @GetMapping("/cambiarEstado/{id}")
    public String cambiarEstadoReserva(@PathVariable  ("id") Long id) {
        reservaService.cambiarEstado(id);
        return "redirect:/reserva";
    }

    @GetMapping("/modificarReserva/{id}")
    public String modificarReserva(@PathVariable ("id") Long id, Model model) {
        Reserva reserva = reservaService.findById(id);
        System.out.println("ID: " + reserva.getId());
        System.out.println("FECHA: " + reserva.getFecha());
        System.out.println("HORA INICIO: " + reserva.getHoraInicio());
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicioService.findAll());
        model.addAttribute("usuarios", usuarioService.findAll());
        return "crear_reserva";
    }
    
    
    
    
}
