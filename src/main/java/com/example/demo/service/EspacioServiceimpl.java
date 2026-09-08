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
    
}
