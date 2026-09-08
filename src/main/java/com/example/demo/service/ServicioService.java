package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Servicio;

public interface ServicioService {
    public Servicio findById(Long id);
    public Collection<Servicio> findAll();
    public Servicio save(Servicio servicio);
}
