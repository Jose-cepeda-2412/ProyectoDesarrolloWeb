package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Espacio;

public interface EspacioService {
    public Espacio findById(Long id);
    public Collection<Espacio> findAll();
    public Espacio save(Espacio espacio);
    public Espacio cambiarEstado(Long id);
}
