package com.uem.crudvideojuego.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uem.crudvideojuego.modelo.persistencia.DaoVideojuego;
import com.uem.crudvideojuego.modelo.entidad.Videojuego;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	//Listar todos los videojuegos
	@GetMapping("videojuegos")
	public ResponseEntity<List<Videojuego>> listar() {
		List<Videojuego> lista = daoVideojuego.getListado();
		
		ResponseEntity<List<Videojuego>> re = new ResponseEntity<List<Videojuego>>(lista, HttpStatus.OK);
		return re;
	}
	
	//Obtener por id
	@GetMapping("videojuegos/{id}")
	public ResponseEntity<Videojuego> obtener(@PathVariable("id") int idVideojuego) {
		System.out.println("[INFO] El id buscado es: " + idVideojuego);
		
		Videojuego v = daoVideojuego.selectById(idVideojuego);
		HttpStatus hs = null;
		if (v != null) {
			hs = HttpStatus.OK;
		} else {
			hs = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(v, hs);
		
		return re;
	}
	
	//Modificar por id
	@PutMapping("videojuegos/{id}")
	public ResponseEntity<Videojuego> modificar(@RequestBody Videojuego v, @PathVariable("id") int idVideojuego) {
		v.setId(idVideojuego);
		
		Videojuego vModif = daoVideojuego.updateById(v);
		
		HttpStatus hs = null;
		if (vModif != null) {
			hs = HttpStatus.OK;
		} else {
			hs = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(vModif, hs);
		
		return re;
	}
	
	//Insertar
	@PostMapping("videojuegos")
	public ResponseEntity<Videojuego> alta(@RequestBody Videojuego v) {
		Videojuego vAlta = daoVideojuego.addVideojuego(v);
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(vAlta,HttpStatus.CREATED);
		return re;
	}
	
	//Eliminar por id
	@DeleteMapping("videojuegos/{id}")
	public ResponseEntity<Videojuego> borrar(@PathVariable("id") int idV) {
		Videojuego v = daoVideojuego.removeById(idV);
		HttpStatus hs = null;
		if (v != null) {
			hs = HttpStatus.OK;
		} else {
			hs = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(v, hs);
		
		return re;
	}

}
