package com.uem.restvideojuego.modelo.persistencia;

import java.util.List;
import com.uem.restvideojuego.modelo.entidad.Videojuego;

public class DaoVideojuego {
	
	private List<Videojuego> listaVideojuego;
	private int id;
	
	public DaoVideojuego() {
		id = 0;
		
		Videojuego v1 = new Videojuego();
		id++;
		v1.setId(id);
		v1.setNombre("Sonic");
		v1.setCompania("SEGA");
	}

}
