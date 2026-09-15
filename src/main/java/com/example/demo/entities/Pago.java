package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class Pago {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private Double monto;
    @Column (nullable = false, length = 50)
    private String metodoPago;
    @Column (nullable = false)
    private Boolean estado;

    @OneToOne 
    private Reserva reserva;

    public Pago(Double monto, String metodoPago, Boolean estado){
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }
}
