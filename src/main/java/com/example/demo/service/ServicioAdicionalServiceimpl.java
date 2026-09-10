package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ServicioAdicional;
import com.example.demo.repository.ServicioAdicionalRepository;

@Service 
public class ServicioAdicionalServiceimpl implements ServicioAdcionalService{
    
    @Autowired 
    private ServicioAdicionalRepository servicioAdicionalRepository;

    @Override 
    public ServicioAdicional findById(Long id){
        return servicioAdicionalRepository.findById(id).orElse(null);
    }

    @Override 
    public Collection<ServicioAdicional> findAll(){
        return servicioAdicionalRepository.findAll();
    }

    @Override 
    public ServicioAdicional save(ServicioAdicional servicioAdicional){
        return servicioAdicionalRepository.save(servicioAdicional);
    }

    @Override 
    public void activar(Long id){
        ServicioAdicional servicioAdicional = findById(id);
        if (servicioAdicional != null && servicioAdicional.getActivo() != true) {
            servicioAdicional.setActivo(true);
            servicioAdicionalRepository.save(servicioAdicional);
        }
    }

    @Override 
    public void desactivar(Long id){
        ServicioAdicional servicioAdicional = findById(id);
        if (servicioAdicional != null && servicioAdicional.getActivo() != false) {
            servicioAdicional.setActivo(false);
            servicioAdicionalRepository.save(servicioAdicional);
        }

    }





}
