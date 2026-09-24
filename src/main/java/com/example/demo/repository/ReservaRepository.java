package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    //consulta para reservas activas
    @Query (
        """
          SELECT r
          FROM Reserva r
          WHERE r.estado = true     
        """
    )
    List<Reserva> buscarReservasActivas();
}