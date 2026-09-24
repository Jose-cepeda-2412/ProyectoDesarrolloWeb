package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Reserva;

public interface ReservaService {
    public Reserva findById(Long id);
    public Collection<Reserva> findAll();
    public Reserva save(Reserva reserva);    
    public Reserva cambiarEstado(Long id);
    public Reserva crearReserva();
    public void guardarReserva(Reserva reserva);
}
