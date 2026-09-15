package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Usuario;
import com.example.demo.service.UsuarioService;



@RequestMapping ("/usuario")
@Controller 
public class UsuarioController {

    @Autowired 
    private UsuarioService usuarioService;

    @GetMapping()
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "listarUsuarios";
    }
    

    @GetMapping("/crearUsario")
    public String crearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "CrearUsuario";
    }
    
}
