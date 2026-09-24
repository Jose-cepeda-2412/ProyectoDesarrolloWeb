package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Reserva;
import com.example.demo.entities.Servicio;
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
        }else if(reserva.getId() != null && reserva.getEstado() == false){
            reserva.setEstado(true);
        }
        return reservaRepository.save(reserva);
    }
    
    @Override 
    public Reserva crearReserva(){
        return new Reserva();
    }

    @Override 
    public void guardarReserva(Reserva reserva){
        if (reserva.getId() != null) {
            Reserva reservaDatosAnteriores = reservaRepository.findById(reserva.getId()).get();
            //si el usuario no cambio la Fecha y la Hora de inicio queda igual a como estaba 
            if (reserva.getFecha() == null) {
                reserva.setFecha(reservaDatosAnteriores.getFecha());
            }
            if (reserva.getHoraInicio() == null) {
                reserva.setHoraInicio(reservaDatosAnteriores.getHoraInicio());
            }
            reserva.setFechaSolicitud(reservaDatosAnteriores.getFechaSolicitud());
            reserva.setEstado(reservaDatosAnteriores.getEstado());
        }else{
            reserva.setEstado(true);
            reserva.setFechaSolicitud(LocalDate.now());
        }

        Double totalPagar = 0.0;
        int duracionTotal = 0;
        for (Servicio servicio : reserva.getServicio()) {
            totalPagar += servicio.getPrecio();
            duracionTotal += servicio.getDuracion();
        }
        reserva.setHoraFin(reserva.getHoraInicio().plusMinutes(duracionTotal));
        reserva.setTotal(totalPagar);
        reservaRepository.save(reserva);
    }
}
