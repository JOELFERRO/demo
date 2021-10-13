package com.libreriaSpring.demo.services;

import com.libreriaSpring.demo.entities.Autor;
import com.libreriaSpring.demo.exceptions.ErrorServicio;
import com.libreriaSpring.demo.repositories.AutorRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {
    
    @Autowired
    private AutorRepository autorRepository;
    
    
    @Transactional
    public void guardarAutor(String nombre) throws ErrorServicio{
        
        /*Validaciones*/
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre del usuario no puede ser nulo.");
        }
        
        Autor autor = new Autor();
        autor.setNombre(nombre);
        Date hoy = new Date();
        autor.setAlta(hoy);
        
        autorRepository.save(autor);
    }
    
    public void editarAutor(String nombre)
    
    @Transactional
    public void eliminarAutor(String id){
        autorRepository.deleteById(id);
    } 
    
    @Transactional
    public void buscarPorId(String id){
        Optional<Autor> autor = autorRepository.findById(id);
    }
    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }
}
