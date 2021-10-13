package com.libreriaSpring.demo.services;

import com.libreriaSpring.demo.entities.Editorial;
import com.libreriaSpring.demo.repositories.EditorialRepository;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepository editorialRepository;
    
    @Transactional
    public void guardarEditorial(String nombre){
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        Date hoy = new Date();
        editorial.setAlta(hoy);
        
        editorialRepository.save(editorial);
    }
    
    @Transactional
    public void eliminarEditorial(String id){
        editorialRepository.deleteById(id);
    } 
    
    public List<Editorial> listarEditoriales(){
        return editorialRepository.findAll();
    }
}
