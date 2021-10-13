package com.libreriaSpring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
/*Modificaciones
1-index.html: formato desde linea 12
2-autorController: se agrega el @RequestParam en los atributos de los métodos registar y eliminar. 
El @RequestParam se usa para determinar que esos atributos provienen del front y son requeridos por el back mediante el form.
3-Crear paquete de errores/excepciones para las validaciones. Las valid se hacen en el service 
4-AutorEntidad: cambiar el tipo de fecha a @Temporal(TemporalType.TIMESTAMP) que guarda la fecha y hora en que se crea el objeto.
*/