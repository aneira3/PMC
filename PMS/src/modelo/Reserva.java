package modelo;

public class Reserva {
	
	private int NumeroHabitacion;
	
	private String NombreHuesped;
	
	
	public Reserva(int numero, String nombre) {
		this.NumeroHabitacion = numero;
		this.NombreHuesped = nombre;
	}

	
	public int getNumeroHabitacion() {
		return NumeroHabitacion;
	}
}