package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    
}
