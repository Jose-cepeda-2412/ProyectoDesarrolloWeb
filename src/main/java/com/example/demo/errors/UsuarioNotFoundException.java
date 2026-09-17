package com.example.demo.errors;

public class UsuarioNotFoundException extends RuntimeException{
    
    public UsuarioNotFoundException(Long id){
        super("No se pudo encontrar el estudiante con id" + id);
    }
}
