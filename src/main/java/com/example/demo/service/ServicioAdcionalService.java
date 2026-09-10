package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.ServicioAdicional;

public interface ServicioAdcionalService {
    public ServicioAdicional findById(Long id);
    public Collection<ServicioAdicional> findAll();
    public ServicioAdicional save(ServicioAdicional servicioAdicional);
    public void activar(Long id);
    public void desactivar(Long id);
}
