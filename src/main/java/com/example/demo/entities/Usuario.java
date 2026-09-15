package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @Column (nullable = false, length = 100)    
    private String contrasenia;
    @Column (nullable = false, length = 50)
    private String rol;
    @Column (nullable = false)
    private Boolean activo;
    @Column (nullable = false)
    private Date fechaRegistro;
    @OneToMany (mappedBy = "usuario")
    private List<Reserva> reserva;


    public Usuario(String nombre, String email, String telefono, String contrasenia, String rol, Boolean activo, Date fechaRegistro){
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }
}
