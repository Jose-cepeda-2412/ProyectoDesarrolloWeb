package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Disponibilidad;
import com.example.demo.repository.DisponibilidadRepository;

@Service 
public class DisponibilidadServiceimpl implements DisponibilidadService {
    
    @Autowired 
    private DisponibilidadRepository disponibilidadRepository;


    @Override
    public Disponibilidad findById(Long id){
        return disponibilidadRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Disponibilidad> findAll(){
        return disponibilidadRepository.findAll();
    }
    
    @Override
    public Disponibilidad save(Disponibilidad disponibilidad){
        return disponibilidadRepository.save(disponibilidad);
    }
    @Override 
    public void cambiarEstado(Long id, String estado){
        Disponibilidad disponibilidad = findById(id);
        if(disponibilidad != null){
            disponibilidad.setEstado(estado);
            disponibilidadRepository.save(disponibilidad);
        }
    }

}
