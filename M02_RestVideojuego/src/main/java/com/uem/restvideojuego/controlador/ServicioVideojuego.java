package com.uem.restvideojuego.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uem.restvideojuego.modelo.entidad.Videojuego;

@RestController
public class ServicioVideojuego {
	
	private Videojuego vid;
	
	@GetMapping("vid")
	public Videojuego getVideojuego() {
		System.out.println("[INFO] Peticion recibida");
		
		vid = new Videojuego();
		vid.setId(33);
		vid.setComp("Noentiendo");
		vid.setNombre("Bomberman");
		vid.setPrecio(21.99);
			
		return vid;
	
	}
	
	@PutMapping("vid")
	public String updatePrecio() {
		System.out.println("[INFO] Precio modificado (-10)");
		
		double precioNew = vid.getPrecio() + 10;
		vid.setPrecio(precioNew);
		
		return "OK";
	}

}
