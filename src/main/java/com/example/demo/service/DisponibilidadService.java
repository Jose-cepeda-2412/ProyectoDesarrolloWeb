package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Disponibilidad;

public interface DisponibilidadService {
    
    public Disponibilidad findById(Long id);
    public Collection<Disponibilidad> findAll();
    public Disponibilidad save(Disponibilidad disponibilidad);
    public void cambiarEstado(Long id, String estado);

}
