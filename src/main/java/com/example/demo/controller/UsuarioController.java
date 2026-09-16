package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entities.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;

@RequestMapping ("/usuario")
@Controller 
public class UsuarioController {

    @Autowired 
    private UsuarioService usuarioService;

    @GetMapping()
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "Listar_usuarios";
    }
    

    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Crear_usuario";
    }

    @PostMapping("/guardar")
    public String postMethodName(@ModelAttribute("usuario")  Usuario usuario) {    
        
        if (usuario.getId() != null) {
            Usuario usuario2 = usuarioService.findById(usuario.getId());
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
        
        usuarioService.save(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable ("id") Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        model.addAttribute("usuario", usuario);
        return "Crear_usuario";
    }
    
    @GetMapping("/cambiarEstado/{id}")
    public String cambiarEstadoUsuario(@PathVariable ("id") Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario.getId() != null) {
            usuarioService.cambiarEstado(id);           
        }
        return "redirect:/usuario";
    }
    
}
