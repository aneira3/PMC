package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Sistema_Consumos {
	
	BaseDatos datos = new BaseDatos();
	public Sistema_Consumos () {
		
	}
	public void abrir_registro_consumo ( int habitacion_registrada) throws ClassNotFoundException, IOException {
		
		// Al abrir un consumo este debe incluir el alojamiento
		Servicio alojamiento= new Servicio("Alojamineto",null,null,8005,"Alojamiento");
		Consumo Consumo = new Consumo(alojamiento.getValor(), alojamiento, habitacion_registrada, false, alojamiento.getTipo());
		//MIRAR DE DONDE SALE EL PRECIO DEL ALOJAMIENTO, del archivo???
		//si sale del archivo de servicios, que es un mapa de habitación valores
		
		ArrayList<Consumo> lista=new  ArrayList<Consumo>();
		lista.add(Consumo);
		Map<Integer, ArrayList<Consumo> > mapa = datos.GetConsumos();
		if (mapa.containsKey(Consumo.GetNumero())) {
			System.out.println("Ya existe un registro de consumo asociado a la habitación "+ habitacion_registrada + ". Por tanto, no se puede abrir uno nuevo");
		}else {
			datos.GuardarObjeto(Consumo);
			System.out.println("Se ha creado un registro asociado a la habitación: " + habitacion_registrada );
			System.out.print("\n");
			System.out.println("Recuerda que el primer consumo es el alojamiento, y se paga siempre en el Check-out");
		}
	}
	public void modificar_registro_consumo (int Habitacion_registrada,String name_service,boolean pago) throws ClassNotFoundException, IOException {
		//ya conozco el consumo
		Map<Integer, ArrayList<Consumo>> mapa = datos.GetConsumos();
		//Map<String, Servicio> servicios = datos.GetServicios();
		Map<String, Producto > menu = datos.GetMenu();
		Map<String, Servicio > servicios = datos.GetServicios();
		if (mapa.containsKey(Habitacion_registrada)) {
			//añadir un consumo a la lista de consumos según la habitación
			ArrayList<Consumo> lista = mapa.get(Habitacion_registrada);
			//Producto xd = menu.get(name_service);
			//(mapa.get(Consumo.getHabitacion_registrada()).add(Consumo);
			if (menu.containsKey(name_service)) {
				Producto service = menu.get(name_service);
				Consumo consumo=new Consumo(service.getValor(), service, Habitacion_registrada, pago, service.getTipo());
				datos.GuardarObjeto(consumo);
				System.out.println("Se ha añadido el consumo de: "+name_service+ " al registro de la habitación: "+ Habitacion_registrada);
			}
			else {
				System.out.println("El producto "+name_service+ "no está en la base de datos");
			}
			if (servicios.containsKey(name_service)) {
				Servicio service = servicios.get(name_service);
				Consumo consumo=new Consumo(service.getValor(), service, Habitacion_registrada, pago, service.getTipo());
				datos.GuardarObjeto(consumo);
					
			}else {
				System.out.println("El servicio "+name_service+ "no está en la base de datos");
			}
			
		}else {
			System.out.println("La habitación"+Habitacion_registrada+ "no tiene un registro de consumo asociado");
			
		}
	}
	public void eliminar_registro_consumo (int Habitacion_registrada) throws IOException, ClassNotFoundException {
		//ya conozco el consumo
		Map<Integer, ArrayList<Consumo> > mapa = datos.GetConsumos();
		Servicio alojamiento= new Servicio("Alojamineto",null,null,8005,"Alojamiento");
		Consumo Consumo = new Consumo(alojamiento.getValor(), alojamiento, Habitacion_registrada, false, alojamiento.getTipo());
		Class<?> clase = Consumo.getClass();
		if (mapa.containsKey(Habitacion_registrada)) {
			//eliminar un consumo dado el # de habitación, debido al check-out
			//mapa.remove(Habitacion_registrada);
			datos.EliminarObjeto(Habitacion_registrada, clase);
			System.out.println("Se ha eliminado el registro de Consumo asociado a la habitación: "+Habitacion_registrada);
		}else {
			System.out.println("La habitación"+Habitacion_registrada+ "no tiene un registro de consumo asociado");
			
		}
	}
}
