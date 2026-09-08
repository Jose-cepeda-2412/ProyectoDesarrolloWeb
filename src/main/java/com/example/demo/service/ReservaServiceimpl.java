package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Reserva;
import com.example.demo.repository.ReservaRepository;

@Service 
public class ReservaServiceimpl implements ReservaService{

    @Autowired 
    private ReservaRepository reservaRepository;



    @Override
    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Reserva> findAll() {
        return reservaRepository.findAll();
    }


    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
    
}
