package com.example.demo.entities;

import java.util.Date;

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
public class Disponibilidad {
    //disponibilidad
    //id espacio
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private Date horaInicio;
    @Column (nullable = false)
    private Date horaFin;
    @Column (nullable = false)
    private String estado;

    public Disponibilidad(Date horaInicio, Date horaFin, String estado){
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
    }

}
