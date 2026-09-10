package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Disponibilidad;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {
    
}
