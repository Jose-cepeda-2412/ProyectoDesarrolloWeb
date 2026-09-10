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
@NoArgsConstructor 
@Setter 
@Getter 
public class Reserva {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private Usuario usuario;
    @Column (nullable = false)
    private String fecha;
    @Column (nullable = false)
    private String horaInicio;
    @Column (nullable = false)
    private String horaFin;
    @Column (nullable = false)
    private Boolean estado;
    @Column (nullable = false)
    private Date fechaSolitiud;
    @Column (nullable = true, length = 200)
    private String observaciones;
    @Column (nullable = true)
    private Double total;

    public Reserva(Usuario usuario, String fecha, String horaInicio, String horaFin, Boolean estado, Date fechaSolitiud, String observaciones, Double total){
        this.usuario = usuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.fechaSolitiud = fechaSolitiud;
        this.observaciones = observaciones;
        this.total = total;
    }
    
}


