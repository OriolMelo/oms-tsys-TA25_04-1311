package oms.UD25.services;

import java.util.List;

import oms.UD25.dto.Sala;

public interface ISalaService {
	//Metodos del CRUD
		public List<Sala> listarSalas(); //Listar All 
		
		public Sala guardarSala(Sala sala);	//Guarda un video CREATE
		
		public Sala salaXID(int codigo); //Leer datos de un video READ
		
		public Sala actualizarSala(Sala sala); //Actualiza datos del video UPDATE
		
		public void eliminarSala(int codigo);// Elimina el video DELETE
}
