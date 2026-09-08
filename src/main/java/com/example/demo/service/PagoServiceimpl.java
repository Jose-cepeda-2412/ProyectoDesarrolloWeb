package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pago;
import com.example.demo.repository.PagoRepository;

@Service 
public class PagoServiceimpl  implements PagoService {

    @Autowired 
    private PagoRepository pagoRepository;

    @Override
    public Collection<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago findById(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public Pago save(Pago pago) {
       return pagoRepository.save(pago);
    }

    
    
}
