package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Espacio;
import com.example.demo.repository.EspacioRespository;

@Service 
public class EspacioServiceimpl implements EspacioService {

    @Autowired 
    private EspacioRespository espacioRepository;


    @Override
    public Espacio findById(Long id) {
        return espacioRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Espacio> findAll() {
        return espacioRepository.findAll();
    }

    @Override 
    public Espacio save(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    @Override 
    public Espacio cambiarEstado(Long id){
        Espacio espacio = espacioRepository.findById(id).get();
        if (espacio.getActivo() == true) {
            espacio.setActivo(false);
        }else if (espacio.getActivo() == false) {
            espacio.setActivo(true);
        }
        return espacioRepository.save(espacio);
    }

    @Override 
    public void guardarEspacio(Espacio espacio){
    
        if (espacio.getId() == null) {
            espacio.setActivo(true);   
        }else{
            Espacio espacioExistente = espacioRepository.findById(espacio.getId()).get();
            espacio.setActivo(espacioExistente.getActivo());
        }
        espacioRepository.save(espacio);
    }

    @Override 
    public Espacio crearEspacio(){
        return new Espacio();
    }
    
}
