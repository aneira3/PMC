package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public  class Servicio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2014793152791090401L;
	/**
	 * 
	 */
	
	//Atributes
	private String tipo;
	//private String ubicacion;
	private  ArrayList<String> dias;
	private String horario; //puede ser un date QUITAR LA FECHAAA!!!!!!
	private int valor;
	private String nombre;
	//PROTECTED???
	//constructor
	/**
	 * @param tipo
	 * @param ubicacion
	 * @param dias
	 * @param horario
	 * @param valor
	 * @param nombre
	 */
	public Servicio(String tipo,  ArrayList<String> dias, String horario, int valor, String nombre) {
		this.tipo = tipo;
		//this.ubicacion = ubicacion;
		this.dias = dias;
		this.horario = horario;
		this.valor = valor;
		this.nombre = nombre;
	}
	//methods
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	/**
	 * @return the dias
	 */
	public ArrayList<String> getDias() {
		return dias;
	}
	/**
	 * @param dias the dias to set
	 */
	public void setDias(ArrayList<String> dias) {
		this.dias = dias;
	}
	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setPrecio(int valor) {
		this.valor = valor;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "[nombre = " + nombre + ", valor = " + valor + ", horario = " + horario + ", días = " + dias + ", tipo = "
				+ tipo + "]";
	}
	
	
}
