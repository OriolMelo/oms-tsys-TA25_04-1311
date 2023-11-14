package oms.UD25.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import oms.UD25.dto.Pelicula;
import oms.UD25.dao.IPeliculaDAO;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	IPeliculaDAO iPeliculaDAO;
	
	@Override
	public List<Pelicula> listarPeliculas() {
		
		return iPeliculaDAO.findAll();
	}
	
	@Override
	public Pelicula guardarPelicula(Pelicula pelicula) {
		
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public Pelicula peliculaXID(int id) {
		
		return iPeliculaDAO.findById(id).get();
	}

	@Override
	public Pelicula actualizarPelicula(Pelicula pelicula) {
		
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public void eliminarPelicula(int id) {
		
		iPeliculaDAO.deleteById(id);
		
	}
}
