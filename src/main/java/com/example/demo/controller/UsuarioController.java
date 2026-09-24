package com.example.demo.controller;

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
        model.addAttribute("usuario", usuarioService.crearUsuario());
        return "Crear_usuario";
    }

    @PostMapping("/guardar")
    public String postMethodName(@ModelAttribute("usuario")  Usuario usuario) {    
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("usuario", usuarioService.findById(id));
        return "Crear_usuario";
    }
    
    @GetMapping("/cambiarEstado/{id}")
    public String cambiarEstadoUsuario(@PathVariable ("id") Long id) {
        usuarioService.cambiarEstado(id);
        return "redirect:/usuario";
    }
    
}
