package modelo;

import java.util.ArrayList;

public class Producto extends Servicio{
	 private static final long serialVersionUID = -2014793152791090401L;
	 private transient String disponibilidadComida; // Desayuno, Almuerzo, Cena, Permanete
	 private transient String disponibilidadTipo; // Habitación,Comedor
	/**
	 * @param tipo
	 * @param dias
	 * @param horario
	 * @param valor
	 * @param nombre
	 * @param disponibilidadComida
	 * @param disponibilidadTipo
	 */
	protected Producto(String tipo, ArrayList<String> dias, String horario, int valor, String nombre,
			String disponibilidadComida, String disponibilidadTipo) {
		super(tipo, dias, horario, valor, nombre);
		this.disponibilidadComida = disponibilidadComida;
		this.disponibilidadTipo = disponibilidadTipo;
	}
	/**
	 * @return the disponibilidadComida
	 */
	public String getDisponibilidadComida() {
		return disponibilidadComida;
	}
	/**
	 * @param disponibilidadComida the disponibilidadComida to set
	 */
	public void setDisponibilidadComida(String disponibilidadComida) {
		this.disponibilidadComida = disponibilidadComida;
	}
	/**
	 * @return the disponibilidadTipo
	 */
	public String getDisponibilidadTipo() {
		return disponibilidadTipo;
	}
	/**
	 * @param disponibilidadTipo the disponibilidadTipo to set
	 */
	public void setDisponibilidadTipo(String disponibilidadTipo) {
		this.disponibilidadTipo = disponibilidadTipo;
	}
	
}
