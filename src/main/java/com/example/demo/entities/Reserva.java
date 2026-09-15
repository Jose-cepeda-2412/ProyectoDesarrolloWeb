package com.example.demo.entities;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    private Usuario usuario; 

    @OneToMany (mappedBy = "reserva")
    private List<Servicio> servicio;

    @OneToOne (mappedBy = "reserva")
    private Pago pago;

    public Reserva(String fecha, String horaInicio, String horaFin, Boolean estado, Date fechaSolitiud, String observaciones, Double total){
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.fechaSolitiud = fechaSolitiud;
        this.observaciones = observaciones;
        this.total = total;
    }
    
}


