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

import oms.UD25.dto.Sala;
import oms.UD25.services.SalaServiceImpl;

@RestController
@RequestMapping("/salas")
public class SalaController {
	@Autowired
	SalaServiceImpl salaServiceImpl;
	
	@GetMapping("/all")
	public List<Sala> listarSalas(){
		return salaServiceImpl.listarSalas();
	}
	
	
	@PostMapping("/add")
	public Sala salvarSala(@RequestBody Sala sala) {
		
		return salaServiceImpl.guardarSala(sala);
	}
	
	
	@GetMapping("/{codigo}")
	public Sala salaXID(@PathVariable(name="codigo") int id) {
		
		Sala sala_xid= new Sala();
		
		sala_xid=salaServiceImpl.salaXID(id);
		
		System.out.println("Sala XID: "+sala_xid);
		
		return sala_xid;
	}
	
	@PutMapping("/{codigo}")
	public Sala actualizarSala(@PathVariable(name="codigo")int id,@RequestBody Sala sala) {
		
		Sala sala_seleccionado= new Sala();
		Sala sala_actualizado= new Sala();
		
		sala_seleccionado= salaServiceImpl.salaXID(id);

		sala_seleccionado.setNombre(sala.getNombre());
		sala_seleccionado.setPelicula(sala.getPelicula());
		
		sala_actualizado = salaServiceImpl.actualizarSala(sala_seleccionado);
		
		System.out.println("El sala actualizado es: "+ sala_actualizado);
		
		return sala_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eliminarSala(@PathVariable(name="codigo")int id) {
		salaServiceImpl.eliminarSala(id);
		System.out.println("Sala eliminado");
	}
}
