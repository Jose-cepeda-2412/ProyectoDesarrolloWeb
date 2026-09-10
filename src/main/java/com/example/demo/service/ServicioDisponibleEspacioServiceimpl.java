package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ServicioDisponibleEspacio;
import com.example.demo.repository.ServicioDisponibleEspacioRepository;

@Service 
public class ServicioDisponibleEspacioServiceimpl implements ServicioDisponibleEspacioService{
    
    @Autowired 
    private ServicioDisponibleEspacioRepository servicioDisponibleEspacioRepository;

    public ServicioDisponibleEspacio findById(Long id){
        return servicioDisponibleEspacioRepository.findById(id).orElse(null);
    }

    public Collection<ServicioDisponibleEspacio> findAll(){
        return servicioDisponibleEspacioRepository.findAll();
    }

    public ServicioDisponibleEspacio save(ServicioDisponibleEspacio servicioDisponibleEspacio){
        return servicioDisponibleEspacioRepository.save(servicioDisponibleEspacio);
    }

    public void cambiarIncluido(Long id, String incluido){
        ServicioDisponibleEspacio servicioDisponibleEspacio = findById(id);
        if (servicioDisponibleEspacio != null) {
            servicioDisponibleEspacio.setIncluido(incluido);
            servicioDisponibleEspacioRepository.save(servicioDisponibleEspacio);
        }
    }

}
