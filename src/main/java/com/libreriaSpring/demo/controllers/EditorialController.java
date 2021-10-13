package com.libreriaSpring.demo.controllers;

import com.libreriaSpring.demo.entities.Editorial;
import com.libreriaSpring.demo.services.EditorialServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialServicio editorialServicio;
    
    //EDITORIAL
    @PostMapping("/registrarEditorial")
    public String registrarEditorial(String nombreEditorial){
//        try{
        editorialServicio.guardarEditorial(nombreEditorial);
        return "index";
//        }catch(NullPointerException e){
//        return "index";
//        }
    }
    
    @RequestMapping("/eliminarEditorial")
    public String eliminarEditorial(String id){
        try{
          editorialServicio.eliminarEditorial(id);
        return "redirect:/editorial/listar_editorial"; 
        }catch(Exception e){
          return "redirect:/editorial/listar_editorial"; 
        }
    }
    
    @GetMapping("/listar_editorial")
    public String listarEditorial(Model model){
        try{
        List<Editorial> editorialList = editorialServicio.listarEditoriales();
        model.addAttribute("titulo", "LISTA DE EDITORIAL");
        model.addAttribute("editorial", editorialList);
        return "listar_editorial";
        }catch(NullPointerException e){
        return "listar_editorial";
        }
    }
}
