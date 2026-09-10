package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ServicioAdicional;

public interface ServicioAdicionalRepository extends JpaRepository<ServicioAdicional, Long> {
    
}
