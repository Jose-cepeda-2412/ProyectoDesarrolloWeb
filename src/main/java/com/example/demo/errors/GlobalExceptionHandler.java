package com.example.demo.errors;

import java.rmi.StubNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler (UsuarioNotFoundException.class)
    public String handleUserNotFound(StubNotFoundException ex, Model model){
        model.addAttribute("mensaje", ex.getMessage());
        return "error";
    }
    
}
