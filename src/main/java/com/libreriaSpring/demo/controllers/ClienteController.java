package com.libreriaSpring.demo.controllers;

import com.libreriaSpring.demo.exceptions.ErrorServicio;
import com.libreriaSpring.demo.services.ClienteServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;
    
    //CLIENTE
    @PostMapping("/guardarCliente")
    public String guardarCliente(Model model, @RequestParam String nombre, @RequestParam Long documento, @RequestParam String telefono){
        
        try {
            clienteServicio.guardarCliente(nombre, documento, telefono);
        } catch (ErrorServicio ex) {
            model.addAttribute("errorA", ex.getMessage());
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
    
}
