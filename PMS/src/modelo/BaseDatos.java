package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDatos implements Serializable {
	
	 
	
	
	/**
	 * 
	 */
	

	public BaseDatos() {
		
	}
	
	// Funciones de creación de archivos
	
	public void CrearArchivoInventario() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoInventario.txt");
	    if (file.createNewFile()) {
	    FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new HashMap<Integer, Habitacion>()); 
		objectOutputStream.close();
	    }
	   
	    
	    }
	   

	public void CrearArchivoUsuarios() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoUsuarios.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoUsuarios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<String, String>()); 
			objectOutputStream.close();
		}
	}
	

	public void CrearArchivoHuespedes() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoHuespedes.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoHuespedes.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<Integer, Huesped>()); 
			objectOutputStream.close();
	}
	}
	

	public void CrearArchivoConsumos() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoConsumos.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoConsumos.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<Integer, ArrayList<Consumo>>()); 
			objectOutputStream.close();
		}
	}
	
	public void CrearArchivoReservas() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoReservas.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoReservas.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<Integer, Reserva>()); 
			objectOutputStream.close();
		}
	}
	
	public void CrearArchivoServicios() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoServicios.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoServicios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<String, Servicio>()); 
			objectOutputStream.close();
		}
	}
	
	public void CrearArchivoMenu() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoMenu.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoMenu.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<String, Producto>()); 
			objectOutputStream.close();
		}
	}
	

	
// Funcion para guardar un objeto en un archivo según la clase del objeto
	
	
	public void GuardarObjeto (Object objeto) throws ClassNotFoundException, IOException {
		//guarda huesped en archivo si no existe
		Class<?> clase = objeto.getClass();
		if (clase.equals(Habitacion.class)){
			Habitacion New = (Habitacion) objeto;
			HashMap<Integer, Habitacion> inventario = GetInventario();
			inventario.put(New.getNumero(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(inventario); 
			objectOutputStream.close();
		}
		else if(clase.equals(Consumo.class)) {
			Consumo New = (Consumo) objeto;
			HashMap<Integer, ArrayList<Consumo>> huespedes = GetConsumos();
			//PUEDE RETORNAR NULL
			ArrayList<Consumo> listaconsumos = huespedes.get(New.GetNumero());
			if ((listaconsumos)==null) {
				listaconsumos =  new  ArrayList<Consumo>();
				listaconsumos.add(New);
			}else {
			//ArrayList<Consumo> listaconsumos = huespedes.get(New.GetNumero());
			listaconsumos.add(New);
			}
			
			huespedes.put(New.GetNumero(), listaconsumos);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoConsumos.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(huespedes); 
			objectOutputStream.close();
		}
		else if(clase.equals(Huesped.class)) {
			Huesped New = (Huesped) objeto;
			HashMap<Integer, Huesped> huespedes = GetHuespedes();
			huespedes.put(New.getNumero(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoHuespedes.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(huespedes); 
			objectOutputStream.close();
		}
		else if (clase.equals(Producto.class)) {
			Producto New = (Producto) objeto;
			HashMap<String, Producto> menu = GetMenu();
			menu.put(New.getNombre(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoMenu.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(menu); 
			objectOutputStream.close();
		}
		else if (clase.equals(Reserva.class)) {
			Reserva New = (Reserva) objeto;
			HashMap<Integer, Reserva> reservas = GetReservas();
			reservas.put(New.getNumeroHabitacion() , New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoReservas.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(reservas); 
			objectOutputStream.close();
		}
		else if (clase.equals(Servicio.class)) {
			Servicio New = (Servicio) objeto;
			HashMap<String, Servicio> servicios = GetServicios();
			servicios.put(New.getNombre(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoServicios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(servicios); 
			objectOutputStream.close();
		}

		
	}
	
	
	
	
	// Funciones para obtener informacion de archivos SISTEMA DE INVENTARIOS
	
	
	public HashMap<Integer,Habitacion> GetInventario () throws IOException, ClassNotFoundException {
		//busca el inventario si existe
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoInventario.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Integer, Habitacion> inventario = (HashMap<Integer, Habitacion>) objectInputStream.readObject();
		objectInputStream.close();
		return inventario;
		
	}
			
	
	// Funciones para obtener informacion de archivos SISTEMA DE REGISTROS DE CONSUMO
	
	
	public HashMap<Integer, ArrayList<Consumo>> GetConsumos() throws IOException, ClassNotFoundException {
		//busca los consumos por huesped si existen 
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoConsumos.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Integer, ArrayList<Consumo>> consumos = (HashMap<Integer, ArrayList<Consumo>>) objectInputStream.readObject();
		objectInputStream.close();
		return consumos;
	}
	
	
	// Funciones para obtener informacion de archivos SISTEMA DE RESERVAS Y REGISTRO
		
	public HashMap<Integer, Reserva> GetReservas() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoReservas.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Integer, Reserva> reservas = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return reservas;
	}
	
	
		public HashMap<Integer, Huesped> GetHuespedes () throws IOException, ClassNotFoundException {
		//busca la informacion de los huespedes si existe
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoHuespedes.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Integer, Huesped> huespedes = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return huespedes;
	}		
		
	
	// Funciones para obtener informacion de archivos ADMINISTRADOR DE USUARIOS
	
	
	public HashMap<String, String> GetUsuarios () {
		return null;
		//busca el mapa de usuarios si existe
	}
	

	// Funciones para obtener informacion de archivos SISTEMA DE SERVICIOS
	
	
	public HashMap<String, Servicio> GetServicios() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoServicios.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<String, Servicio> servicios = (HashMap<String, Servicio>) objectInputStream.readObject();
		objectInputStream.close();
		return servicios;
	}

	
	public HashMap<String, Producto> GetMenu() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoMenu.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<String, Producto> menu = (HashMap<String, Producto>) objectInputStream.readObject();
		objectInputStream.close();
		return menu;
	}
	

	
	
	public void EliminarObjeto(Object objeto, Class<?> clase) throws IOException, ClassNotFoundException {
		if (clase.equals(Habitacion.class)) {
			int numeroHabitacion = (int) objeto;
			HashMap<Integer, Habitacion> inventario = GetInventario();
			inventario.remove(numeroHabitacion) ;
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(inventario); 
			objectOutputStream.close();
		}
		else if (clase.equals(Consumo.class)) {
			int numeroHabitacion = (int) objeto;
			HashMap<Integer, ArrayList<Consumo>> consumos =  GetConsumos();
			consumos.remove(numeroHabitacion);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoConsumos.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(consumos); 
			objectOutputStream.close();
		}
		else if (clase.equals(Huesped.class)) {
			int numeroHabitacion = (int) objeto;
			HashMap<Integer, Huesped> huespedes = GetHuespedes();
			huespedes.remove(numeroHabitacion);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoHuespedes.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(huespedes); 
			objectOutputStream.close();	
		}
		else if (clase.equals(Producto.class)) {
			String nombreProducto = (String) objeto;
			HashMap<String, Producto> menu = GetMenu();
			menu.remove(nombreProducto);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoMenu.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(menu); 
			objectOutputStream.close();
		}
		else if (clase.equals(Reserva.class)) {
			int numeroHabitacion = (int) objeto;
			HashMap<Integer, Reserva> reservas = GetReservas();
			reservas.remove(numeroHabitacion);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoReservas.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(reservas); 
			objectOutputStream.close();
		}
		else if (clase.equals(Servicio.class)) {
			String nombreServicio = (String) objeto;
			HashMap<String, Servicio> servicios = GetServicios();
			servicios.remove(nombreServicio);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoServicios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(servicios); 
			objectOutputStream.close();
		}
		
	}
	
	
	public void AbrirRegistroConsumo(int numeroHabitacion) throws ClassNotFoundException, IOException {
		HashMap<Integer, ArrayList<Consumo>> consumos = GetConsumos();
		consumos.put(numeroHabitacion, new ArrayList<>());
		
	}
	
	
	
	public void EditarServicio(String nombreServicio, int nuevoPrecio) throws ClassNotFoundException, IOException {
		HashMap<String, Servicio> servicios= GetServicios();
		Servicio servicio = servicios.get(nombreServicio);
		servicio.setPrecio(nuevoPrecio);
		GuardarObjeto(servicio);
		
		
	}
	
	public void EditarProducto(String nombreProducto, int nuevoPrecio) throws ClassNotFoundException, IOException {
		HashMap<String, Producto> productos= GetMenu();
		Producto producto = productos.get(nombreProducto);
		producto.setPrecio(nuevoPrecio);
		GuardarObjeto(producto);
	}
	
		
	
	
}