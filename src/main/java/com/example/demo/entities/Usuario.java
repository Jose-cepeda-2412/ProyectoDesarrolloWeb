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
public class Usuario {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, length = 100)
    private String nombre;
    @Column (nullable = false, length = 100, unique = true)
    private String email;
    @Column (length = 20)
    private String telefono;
    @Column (nullable = false)
    private Boolean activo;


    public Usuario(String nombre, String email, String telefono, Boolean activo){
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
    }
}
