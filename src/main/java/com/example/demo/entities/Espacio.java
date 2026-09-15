package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class Espacio {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, length = 50)
    private String nombre;
    @Column (nullable = false, length = 50)
    private String tipo;
    @Column (length = 200)
    private String descripcion;
    @Column (nullable = false)
    private Integer capacidad;
    @Column (nullable = false)
    private Double precio;
    @Column (length = 200)
    private String imagenUrl;
    @Column (nullable = false)
    private Boolean activo;

    @ManyToOne 
    private Servicio servicio;

    public Espacio(String nombre, String tipo, String descripcion, Integer capacidad, Double precio, String imagenUrl, Boolean activo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.activo = activo;
    }

    
}
