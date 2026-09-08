package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    
}
