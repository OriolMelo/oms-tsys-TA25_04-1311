package oms.UD25.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "calificacionEdad")
	private int calificacionEdad;
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Sala> sala;
	
	public Pelicula() {
		
	}

	public Pelicula(int codigo, String nombre, int calificacionEdad, List<Sala> sala) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.calificacionEdad = calificacionEdad;
		this.sala = sala;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacionEdad() {
		return calificacionEdad;
	}

	public void setCalificacionEdad(int calificacionEdad) {
		this.calificacionEdad = calificacionEdad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Sala")
	public List<Sala> getSala() {
		return sala;
	}

	public void setSala(List<Sala> sala) {
		this.sala = sala;
	}
	
}
