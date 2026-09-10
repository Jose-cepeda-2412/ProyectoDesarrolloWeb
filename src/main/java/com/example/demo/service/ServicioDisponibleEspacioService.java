package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.ServicioDisponibleEspacio;

public interface ServicioDisponibleEspacioService {
    
    public ServicioDisponibleEspacio findById(Long id);
    public Collection<ServicioDisponibleEspacio> findAll();
    public ServicioDisponibleEspacio save(ServicioDisponibleEspacio servicioDisponibleEspacio);
    public void cambiarIncluido(Long id, String incluido);
}
