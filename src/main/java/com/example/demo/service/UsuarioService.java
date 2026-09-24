package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Usuario;

public interface UsuarioService {
    public Usuario findById(Long id);
    public Collection<Usuario> findAll();
    public Usuario save (Usuario usuario);
    public void cambiarEstado(Long id);
    public Usuario crearUsuario();
    public void guardarUsuario(Usuario usuario);
}
