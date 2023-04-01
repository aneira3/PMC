
package modelo;

import java.io.Serializable;

public class Habitacion implements Serializable{
	
	/**
	 * 
	 */


	private int PrecioHabitacion;
	
	private int NumeroHabitacion;
	
	private Boolean Disponible;
	
	
	
	public Habitacion(int Precio, int Numero) {
		this.PrecioHabitacion = Precio;
		this.NumeroHabitacion = Numero;
		this.Disponible = true;
	}
	
	
	public int getPrecio() {
		return PrecioHabitacion;
	}
	
	public int getNumero() {
		return NumeroHabitacion;
	}
	
	
	//Actualizar precio y disponibilidad

}