package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;

public class UsuarioServiceimpl implements UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
       return usuarioRepository.findById(id).orElse(null);
    }


    @Override
    public Collection<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
       return usuarioRepository.save(usuario);
    }

    @Override
    public void inactivo(Long id) {
        Usuario usuario = findById(id);
        if(usuario.getActivo() == true && usuario != null){
            usuario.setActivo(false);
            usuarioRepository.save(usuario);
        }
    }



    @Override
    public void activo(Long id) {
        Usuario usuario = findById(id);
        if(usuario.getActivo() == false && usuario != null){
            usuario.setActivo(true);
            usuarioRepository.save(usuario);
        }
        
    }
    
    
}
