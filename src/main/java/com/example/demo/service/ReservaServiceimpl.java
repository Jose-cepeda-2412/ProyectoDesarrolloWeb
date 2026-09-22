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

    @Override 
    public Reserva cambiarEstado(Long id){
        Reserva reserva = reservaRepository.findById(id).get();
        if (reserva.getId() != null && reserva.getEstado() == true) {
            reserva.setEstado(false);
            reservaRepository.save(reserva);
        }else if(reserva.getId() != null && reserva.getEstado() == false){
            reserva.setEstado(true);
            reservaRepository.save(reserva);
        }
        return reservaRepository.save(reserva);
    }
    
}
