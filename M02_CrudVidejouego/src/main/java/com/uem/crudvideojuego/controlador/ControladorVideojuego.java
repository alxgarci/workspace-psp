package com.uem.crudvideojuego.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uem.crudvideojuego.modelo.persistencia.DaoVideojuego;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	//@GetMapping("videojuegos")
	//TODO: Toooodo el controlador :(

}
