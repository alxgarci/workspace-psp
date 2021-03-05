package com.uem.crudvideojuego.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uem.crudvideojuego.modelo.entidad.Videojuego;

@Component
public class DaoVideojuego {
	private List<Videojuego> listaVideojuegos;
	private int c;
	
	public DaoVideojuego() {
		c = 1;
		Videojuego v1 = new Videojuego();
		v1.setId(c);
		v1.setNombre("Sanic");
		v1.setComp("SOGA");
		v1.setPrecio(12.12);
		v1.setPuntuacion(3.2);
		
		Videojuego v2 = new Videojuego();
		v2.setId(c++);
		v2.setNombre("Fifote 2212");
		v2.setComp("EA");
		v2.setPrecio(99.99);
		v2.setPuntuacion(4.3);
		
		listaVideojuegos = new ArrayList<Videojuego>();
		listaVideojuegos.add(v1);
		listaVideojuegos.add(v2);
	}
	
	public List<Videojuego> getListado() {
		return listaVideojuegos;
	}
	
	public Videojuego selectById(int id) {
		Videojuego videojuego = null;
		for (Videojuego v : listaVideojuegos) {
			if (v.getId() == id) {
				videojuego = v;
				break;
			}
			
		}
		return videojuego;
	}
	
	public Videojuego addVideojuego(Videojuego v) {
		v.setId(c++);
		listaVideojuegos.add(v);
		return v;
	}
	
	public Videojuego updateById(Videojuego vUpd) {
		Videojuego v = selectById(vUpd.getId());
		if (v != null) {
			v.setComp(vUpd.getComp());
			v.setPrecio(vUpd.getPrecio());
			v.setPuntuacion(vUpd.getPuntuacion());
			v.setNombre("MODIFICADO");
		}
		return v;
	}
	
	public Videojuego removeById(int id) {
		Videojuego v = selectById(id);
		if (v != null) {
			listaVideojuegos.remove(id);
		}
		return v;
	}

}
