package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Servicio;
import com.example.demo.repository.ServicioRepository;

@Service 
public class ServicioServiceimpl implements ServicioService {


    @Autowired 
    private ServicioRepository servicioRepository;

    @Override
    public Servicio findById(Long id) {
       return servicioRepository.findById(id).orElse(null);
        
    }

    @Override
    public Collection<Servicio> findAll() {
       return servicioRepository.findAll();
        
    }

    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
        
    }

    @Override 
    public Servicio cambiarEstado(Long id){
        Servicio servicio = findById(id);
        if (servicio != null && servicio.getActivo() == false  ) {
            servicio.setActivo(true);
        }else if(servicio != null && servicio.getActivo() == true){
            servicio.setActivo(false);
        }
        return servicioRepository.save(servicio);
    }

    @Override 
    public Servicio crearServicio(){
        return new Servicio();
    }

    @Override 
    public void guardarServicio(Servicio servicio){
        if (servicio.getId() != null) {
            Servicio datosServicio = servicioRepository.findById(servicio.getId()).get();
            servicio.setActivo(datosServicio.getActivo());
        }else{
            servicio.setActivo(true);
        }
        servicioRepository.save(servicio);
    }
    
}
