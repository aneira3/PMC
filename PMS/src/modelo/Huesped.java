package modelo;

import java.io.Serializable;

public class Huesped implements Serializable{

	private String Nombre;
	
	private int NumeroHabitacion;
	
	
	
	public Huesped(String nombre, int numero) {
		this.Nombre = nombre;
		this.NumeroHabitacion = numero;
	}
	
	
	
	public int getNumero() {
		return NumeroHabitacion;
	}
}