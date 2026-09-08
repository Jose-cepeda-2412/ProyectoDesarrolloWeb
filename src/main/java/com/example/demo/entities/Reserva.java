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
    private String hora;

    public Reserva(Usuario usuario, String fecha, String hora){
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
    }
    
}
