package com.libreriaSpring.demo.controllers;

import com.libreriaSpring.demo.entities.Autor;
import com.libreriaSpring.demo.services.AutorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorServicio autorServicio;
    //AUTOR
    @PostMapping("/registrarAutor")
    public String registrarAutor(@RequestParam String nombre, Model model){
        System.out.println("Nombre: " + nombre);
        try{
            autorServicio.guardarAutor(nombre);
        }catch(Exception ErrorServicio){
            model.
        }
        autorServicio.guardarAutor(nombre);
        return "index";
    }
    
    @RequestMapping("/eliminarAutor")
    public String eliminarAutor(@RequestParam String id){
        try{
          autorServicio.eliminarAutor(id);
        return "redirect:/listar_autores"; 
        }catch(Exception e){
          return "redirect:/listar_autores"; 
        }
    }
    
//    @GetMapping("/editar_autor")
//    public String editarAutor(@RequestParam String id, Model model){
//        Autor autor = autorServicio.buscarPorId(id);
//        model.addAttribute("autorE", autor);
//        return "/listar_autores";
//    }
    
    @GetMapping("/listar_autores")
    public String listarAutores(Model model){
        List<Autor> autores = autorServicio.listarAutores();
        model.addAttribute("titulo", "LISTA DE AUTORES");
        model.addAttribute("autores", autores);
        return "listar_autores";
    }
}
