package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.EspacioService;


@Controller 
@RequestMapping ("/espacios")
public class EspacioController {
    
    @Autowired 
    private EspacioService espacioService;

    @GetMapping()
    public String listarEspacios(Model model) {
        model.addAttribute("espacios", espacioService.findAll());
        return "listar_espacios";
    }

    @GetMapping("cambiarEstado/{id}")
    public String getMethodName(@PathVariable ("id") Long id) {
        espacioService.cambiarEstado(id);
        return "redirect:/espacios";
    }
    
    
}
