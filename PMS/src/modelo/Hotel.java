package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel implements Serializable{

	private HashMap<Integer, Habitacion> Inventario; 
	
	private HashMap<String, String> Usuarios;
	
	private ArrayList<Huesped> Huespedes;
	
	private HashMap<Integer, ArrayList<Consumo>> Consumos;
	
	private BaseDatos Administrador_BD;
	
	private Sistema_Consumos sisConsumo;
	
	private Servicio servicio;
	
	private Producto producto;
	
	private Sistema_Servicios sistserv;
	
	public Hotel() {
		this.Inventario = null;
		this.Usuarios = null;
		this.Huespedes = null;
		this.Consumos = null;
		this.Administrador_BD = new BaseDatos();
		this.sisConsumo =new Sistema_Consumos();
		this.sistserv=new Sistema_Servicios();
	}
	
	
	public void setInventario(){
		//Cargar archivo binario
	}
	
	public void setUsuarios(){
		//Cargar archivo binario
	}
	
	public void setHuespedes(){
		//Cargar archivo binario
	}
	
	public void setConsumos(){
		//Cargar archivo binario
	}
	
	
	
	
	
	
	
	
	
	
	public HashMap<Integer, Habitacion> getInventario() throws ClassNotFoundException, IOException{
		return Administrador_BD.GetInventario();
	}
	
	public HashMap<String, String> getUsuarios(){
		return Administrador_BD.GetUsuarios();
	}
	
	public HashMap<Integer, Huesped> getHuespedes() throws ClassNotFoundException, IOException{
		return Administrador_BD.GetHuespedes();
	}
	public HashMap<String, Servicio> GetServicios() throws ClassNotFoundException, IOException{
		return Administrador_BD.GetServicios();
	}
	public HashMap<String, Producto> GetMenu() throws ClassNotFoundException, IOException{
		return Administrador_BD.GetMenu();
	}
	
	public HashMap<Integer, ArrayList<Consumo>> GetConsumos() throws IOException, ClassNotFoundException {
		return Administrador_BD.GetConsumos();
	}
	
	public BaseDatos getBD(){
		return Administrador_BD;
	}
	
	
	public void crearHabitacion(int precio, int numero) throws IOException, ClassNotFoundException
	{
		Habitacion objeto = new Habitacion(precio, numero);
		
	}
	
	public void eliminarObjeto(int numeroHabitacion) throws ClassNotFoundException, IOException {
		Class<Habitacion> clase = Habitacion.class;
		Administrador_BD.EliminarObjeto(numeroHabitacion, clase);
		
	}
	public void eliminar_ser_pro (String nombre)throws ClassNotFoundException, IOException {
		Map<String, Producto > menu = Administrador_BD.GetMenu();
		Map<String, Servicio > servicios = Administrador_BD.GetServicios();
		if (menu.containsKey(nombre)) {
			Producto clasesita =menu.get(nombre);
			String service = (menu.get(nombre)).getNombre();
			Class<?> clase = clasesita.getClass();
			Administrador_BD.EliminarObjeto(service, clase);
			System.out.println("Se ha eliminado el producto de: "+nombre);
		}
		if (servicios.containsKey(nombre)) {
			Servicio clasesita =menu.get(nombre);
			String service = (servicios.get(nombre)).getNombre();
			Class<?> clase = clasesita.getClass();
			Administrador_BD.EliminarObjeto(service, clase);
			System.out.println("Se ha eliminado el servicio de: "+nombre);
		}
		
	}
	
	
	public void GuardarrObjeto(int precio, int numero) throws ClassNotFoundException, IOException {
		Habitacion objeto = new Habitacion(precio, numero);
		Administrador_BD.GuardarObjeto(objeto);
	}
	
	
	//Aguirre
	public void guardarObjeto (String tipo, ArrayList<String> dias, String horas, int valor, String nombre) throws ClassNotFoundException, IOException {
		Servicio objeto = new Servicio( tipo, dias,  horas,  valor,  nombre);
		Administrador_BD.GuardarObjeto(objeto);
	}
	//métodos de consumo
	public void abrirConsumo (int numeroHabitacion) throws ClassNotFoundException, IOException {
		sisConsumo.abrir_registro_consumo(numeroHabitacion);
	}
	
	//métodos de servicios
	public void crear_servicio_file (String ruta) throws FileNotFoundException, IOException {
		sistserv.crear_servicio_file(ruta);
	}
	public void crear_servicio (String tipo,  String dias, String horario, int valor, String nombre) throws ClassNotFoundException, IOException {
		sistserv.crear_servicio(tipo, dias, horario, valor, nombre);
	}
	public void editar_servicio (int valor, String key) throws ClassNotFoundException, IOException {
		sistserv.editar_servicio(valor, key);
		
	}
	public void editar_servicio_file( String ruta) throws FileNotFoundException, IOException {
		sistserv.editar_servicio_file(ruta);
	}
	//métodos de productos
	public void crear_producto_file (String ruta) throws FileNotFoundException, IOException {
		sistserv.crear_producto_file(ruta);
	}
	public void crear_producto (String tipo,  String dias, String horario, int valor, String nombre, String dispoComi, String dispoTipo) throws ClassNotFoundException, IOException {
		sistserv.crear_producto(tipo, dias, horario, valor, nombre, dispoTipo, dispoTipo);
	}
	public void editar_producto (int valor, String key) throws ClassNotFoundException, IOException {
		sistserv.editar_producto(valor, key);
		
	}
	public void editar_producto_file( String ruta) throws FileNotFoundException, IOException {
		sistserv.editar_producto_file(ruta);
	}
	//métodos de consumo
	public void abrir_registro_consumo ( int habitacion_registrada) throws ClassNotFoundException, IOException {
		sisConsumo.abrir_registro_consumo(habitacion_registrada);
	}
	public void modificar_registro_consumo (int Habitacion_registrada,String name_service,boolean pago) throws ClassNotFoundException, IOException {
		sisConsumo.modificar_registro_consumo(Habitacion_registrada, name_service, pago);
	}
	public void eliminar_registro_consumo (int Habitacion_registrada) throws IOException, ClassNotFoundException {
		sisConsumo.eliminar_registro_consumo(Habitacion_registrada);
	}
	
}