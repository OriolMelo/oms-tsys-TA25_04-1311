package oms.UD25.services;

import java.util.List;

import oms.UD25.dto.Pelicula;

public interface IPeliculaService {
	//Metodos del CRUD
	public List<Pelicula> listarPeliculas(); //Listar All 
	
	public Pelicula guardarPelicula(Pelicula pelicula);	//Guarda un video CREATE
	
	public Pelicula peliculaXID(int id); //Leer datos de un video READ
	
	public Pelicula actualizarPelicula(Pelicula pelicula); //Actualiza datos del video UPDATE
	
	public void eliminarPelicula(int id);// Elimina el video DELETE
}
