package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import modelo.Servicio;
public class Consumo implements Serializable {
	
	/**
	 * 
	 */
	
	//Attributes
	private int Cobro;
	private Servicio Servicio_consumido;
	private int Habitacion_registrada;
	private String tipo; //servicio, restaurante, "alojamiento"
	private boolean pago;
	//PONER FECHA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	//Constructor
	/**
	 * @param cobro
	 * @param servicio_consumido
	 * @param habitacion_registrada
	 */
	public Consumo(int cobro, Servicio servicio_consumido, int habitacion_registrada,  boolean pago,String tipo) {
		//super();
		
		this.Servicio_consumido = servicio_consumido;
		//this.setHabitacion_registrada(habitacion_registrada);
		this.Habitacion_registrada=habitacion_registrada;
		this.tipo = tipo;
		//this.setPago(pago);
		this.pago=pago;
		if (pago==true) {
			this.Cobro=0;
		}else {
			this.Cobro = cobro;
		}
	}
	//Retorna el cobro de un servicio
	/**
	 * @return the cobro
	 */
	public int getCobro() {
		return Cobro;
	}
	//Retorna el servicio consumido
	/**
	 * @return the servicio_consumido
	 */
	public Servicio getServicio_consumido() {
		return Servicio_consumido;
	}
	public int GetNumero() {
		return Habitacion_registrada;
	}
	public void setHabitacion_registrada(int habitacion_registrada) {
		Habitacion_registrada = habitacion_registrada;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "[ Cobro = " + Cobro + ", Servicio_consumido = " + Servicio_consumido
				+ ", Habitacion_registrada = " + Habitacion_registrada + ", tipo = " + tipo + ", pago = " + pago + " ]";
	}

	
	
	
}