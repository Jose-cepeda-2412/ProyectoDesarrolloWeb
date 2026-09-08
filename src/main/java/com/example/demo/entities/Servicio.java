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
public class Servicio {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, length = 50)
    private String nombre;
    @Column (nullable = false,length = 200)
    private String descripcion;
    @Column (nullable = false)
    private Double precio;

    public Servicio(String nombre, String descripcion, Double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;

    }
}
