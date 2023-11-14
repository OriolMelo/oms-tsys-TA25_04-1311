package oms.UD25.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oms.UD25.dto.Pelicula;
import oms.UD25.services.PeliculaServiceImpl;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;
	
	@GetMapping("/all")
	public List<Pelicula> listarPeliculaes(){
		return peliculaServiceImpl.listarPeliculas();
	}
	
	
	@PostMapping("/add")
	public Pelicula salvarPelicula(@RequestBody Pelicula pelicula) {
		
		return peliculaServiceImpl.guardarPelicula(pelicula);
	}
	
	
	@GetMapping("/{codigo}")
	public Pelicula peliculaXID(@PathVariable(name="codigo") Integer id) {
		
		Pelicula pelicula_xid= new Pelicula();
		
		pelicula_xid=peliculaServiceImpl.peliculaXID(id);
		
		System.out.println("Pelicula XID: "+pelicula_xid);
		
		return pelicula_xid;
	}
	
	@PutMapping("/{codigo}")
	public Pelicula actualizarPelicula(@PathVariable(name="codigo")Integer id,@RequestBody Pelicula pelicula) {
		
		Pelicula pelicula_seleccionado= new Pelicula();
		Pelicula pelicula_actualizado= new Pelicula();
		
		pelicula_seleccionado= peliculaServiceImpl.peliculaXID(id);
		
		pelicula_seleccionado.setNombre(pelicula.getNombre());
		pelicula_seleccionado.setCalificacionEdad(pelicula.getCalificacionEdad());
		
		pelicula_actualizado = peliculaServiceImpl.actualizarPelicula(pelicula_seleccionado);
		
		System.out.println("El pelicula actualizado es: "+ pelicula_actualizado);
		
		return pelicula_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eliminarPelicula(@PathVariable(name="codigo")Integer id) {
		peliculaServiceImpl.eliminarPelicula(id);
		System.out.println("Pelicula eliminado");
	}
}
