package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
public class Espacio {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, length = 50)
    private String nombre;
    @Column (nullable = false)
    private Integer capacidad;
    @Column (nullable = false)
    private Double precio;
    @Column (nullable = false)
    private Servicio servicio;

    public Espacio(String nombre, Integer capacidad, Double precio, Servicio servicio){
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.servicio = servicio;
    }

    
}
