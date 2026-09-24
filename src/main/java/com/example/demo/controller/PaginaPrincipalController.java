package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
@RequestMapping ()
public class PaginaPrincipalController {
    
    @GetMapping()
    public String mostrarPaguinaPrincipal(Model model) {
        
        return "pagina_principal";
    }
    
}
