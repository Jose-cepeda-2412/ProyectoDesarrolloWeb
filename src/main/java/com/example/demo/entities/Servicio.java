package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
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
    @Column (nullable = false)
    private Boolean activo;

    @ManyToMany  (mappedBy = "servicio")
    private List<Reserva> reserva = new ArrayList<>();

    @ManyToMany 
    private List<Espacio> espacio = new ArrayList<>();

    public Servicio(String nombre, String descripcion, Double precio, Boolean activo){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }
}
