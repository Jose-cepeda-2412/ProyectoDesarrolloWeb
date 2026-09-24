package com.example.demo.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usuario;
import com.example.demo.errors.UsuarioNotFoundException;
import com.example.demo.repository.UsuarioRepository;

@Service 
public class UsuarioServiceimpl implements UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
       return usuarioRepository.findById(id).orElseThrow(
         () -> new UsuarioNotFoundException(id)
       );
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
    public void cambiarEstado(Long id) {
        Usuario usuario = findById(id);
        if(usuario.getActivo() == true ){
            usuario.setActivo(false);
        }else if (usuario.getActivo() == false) {
            usuario.setActivo(true);
        }
        usuarioRepository.save(usuario);
    }
    
    @Override 
    public Usuario crearUsuario(){
        return new Usuario();
    }

    @Override 
    public void guardarUsuario(Usuario usuario){
        if (usuario.getId() != null) {
            Usuario usuario2 = findById(usuario.getId());
            //si el usuario no cambia la contraseña se guarda la anterior
            if (usuario.getContrasenia() == null || usuario.getContrasenia().isBlank()) {
                usuario.setContrasenia(usuario2.getContrasenia());
            }
            usuario.setActivo(usuario2.getActivo());
            usuario.setFechaRegistro(usuario2.getFechaRegistro());
        }else{
            usuario.setActivo(true);
            usuario.setFechaRegistro(new Date());
        }
        
        usuarioRepository.save(usuario);
    }
}
