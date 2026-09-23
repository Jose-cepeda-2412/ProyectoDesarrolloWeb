package com.example.demo.errors;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler (UsuarioNotFoundException.class)
    public String handleUserNotFound(UsuarioNotFoundException ex, Model model){
        model.addAttribute("mensaje", ex.getMessage());
        return "error";
    }
    
}
