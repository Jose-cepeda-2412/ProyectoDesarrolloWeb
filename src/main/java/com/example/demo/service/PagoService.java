package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Pago;

public interface PagoService {

    public Collection<Pago> findAll();
    public Pago findById(Long id);
    public Pago save(Pago pago);
    
}
