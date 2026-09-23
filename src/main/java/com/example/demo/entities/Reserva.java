package com.example.demo.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor 
@Setter 
@Getter 
@AllArgsConstructor 
public class Reserva {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private LocalDate fecha;
    @Column (nullable = false)
    private LocalTime horaInicio;
    @Column (nullable = false)
    private LocalTime horaFin;
    @Column (nullable = false)
    private Boolean estado;
    @Column (nullable = false)
    private LocalDate fechaSolicitud;
    @Column (nullable = false, length = 200)
    private String observaciones;
    @Column (nullable = true)
    private Double total;

    @ManyToOne
    private Usuario usuario; 

    @ManyToMany
    private List<Servicio> servicio = new ArrayList<>();

    @OneToOne (mappedBy = "reserva")
    private Pago pago;

    public Reserva(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Boolean estado, LocalDate fechaSolicitud, String observaciones, Double total){
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.observaciones = observaciones;
        this.total = total;
    }
    
}


