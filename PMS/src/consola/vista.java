package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import modelo.BaseDatos;
import modelo.Consumo;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Huesped;
import modelo.Producto;
import modelo.Servicio;





public class vista {
	
	private Hotel infoHotel;
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		vista Aplicacion = new vista();
		Aplicacion.ejecutarAplicacion();
	}
	
	
	public void ejecutarAplicacion() throws IOException, ClassNotFoundException {
		System.out.println("Hotel El Dorado");
		this.infoHotel = new Hotel();
	


		CrearArchivos();
		String ruta = new String("C://Users//Juan Esteban//Desktop//ANDES//2023-10//DPO//PMS//data/");
		
 		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				//obtener_consumo(505);
				int opcion_seleccionada = Integer.parseInt(input("Por favor selecciona una opción"));
				if (opcion_seleccionada == 1)
					administrador();
				else if (opcion_seleccionada == 2 )
					obtenerMenu();
				else if (opcion_seleccionada == 3 )
					empleado();
				else if (opcion_seleccionada == 4)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
		
		
		
	}
	public void administrador() throws IOException, ClassNotFoundException {
		System.out.println("Interfaz de Administrador");
		this.infoHotel = new Hotel();
	


		CrearArchivos();
		String ruta = new String("C://Users//Juan Esteban//Desktop//ANDES//2023-10//DPO//PMS//data/");
		
 		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu_admin();
				//obtener_consumo(505);
				int opcion_seleccionada = Integer.parseInt(input("Por favor selecciona una opción"));
				if (opcion_seleccionada == 1)
					abrir_consumo();
				else if (opcion_seleccionada == 2 )
					modificar_consumo();
				else if (opcion_seleccionada == 3 )
					eliminar_consumo();
				else if (opcion_seleccionada == 4)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
		
		
		
	}
	public void empleado() throws IOException, ClassNotFoundException {
		System.out.println("Interfaz de Administrador");
		this.infoHotel = new Hotel();
	


		CrearArchivos();
		String ruta = new String("C://Users//Juan Esteban//Desktop//ANDES//2023-10//DPO//PMS//data/");
		
 		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu_empleado();
				//obtener_consumo(505);
				int opcion_seleccionada = Integer.parseInt(input("Por favor selecciona una opción"));
				if (opcion_seleccionada == 1)
					
					crear_servicio();
				else if (opcion_seleccionada == 2 )
					editar_tarifa_servicio();
				else if (opcion_seleccionada == 3 )
					crear_producto();
				else if (opcion_seleccionada == 4 )
					editar_tarifa_producto();
				else if (opcion_seleccionada == 5 )
					eliminar_ser_pro();
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
		
		
		
	}	
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void CrearArchivos() throws IOException {
		BaseDatos BD = infoHotel.getBD();
		BD.CrearArchivoConsumos();
		BD.CrearArchivoHuespedes();
		BD.CrearArchivoInventario();
		BD.CrearArchivoUsuarios();
		BD.CrearArchivoMenu();
		BD.CrearArchivoServicios();
		BD.CrearArchivoReservas();
	}

	
	public void GuardarHabitacion(int precio, int numero) throws IOException, ClassNotFoundException {
		infoHotel.crearHabitacion(precio,numero);
	}
	
	public void ObtenerInventario() throws ClassNotFoundException, IOException {
		Collection<Habitacion> inventario = infoHotel.getInventario().values();
		for (Habitacion element:inventario) {
			System.out.print(element.getPrecio());
			System.out.print("    ");
			System.out.print(element.getNumero());
			System.out.print("\n");
		}
		
	}
	private void obtenerServicios ()throws ClassNotFoundException, IOException {
	Collection<Servicio> servicios = infoHotel.GetServicios().values();
	//System.out.print(" joder   ");
	for (Servicio element:servicios) {
		//System.out.print(element.getValor());
		//System.out.print(" joder   ");
		System.out.print(element.toString());
		System.out.print("\n");
	}
	}
	private void obtenerMenu ()throws ClassNotFoundException, IOException {
		Collection<Producto> xd = infoHotel.GetMenu().values();
		//System.out.print(" joder   ");
		for (Producto element:xd) {
			//System.out.print(element.getValor());
			//System.out.print(" joder   ");
			System.out.print(element.toString());
			System.out.print("\n");
		}
		}
	private void obtener_consumo (int habitacion)throws ClassNotFoundException, IOException {
		HashMap<Integer, ArrayList<Consumo>>  xd = infoHotel.GetConsumos();
		if (xd.containsKey(habitacion)) {
			ArrayList<Consumo> lista =xd.get(habitacion);
			System.out.print("Habitación N.o: " +  habitacion);
			System.out.print("\n");
			int i=0;
			for (Consumo element:lista) {
				System.out.print("Consumo #"+i);
				System.out.print(element.toString());
				System.out.print("\n");
				
				i++;
				
			}	
		} else {
		System.out.print("La habitación: "+habitacion+ "no está en el registro");
		}
		
	}
	private void obtener_consumo_por_habitacion ()throws ClassNotFoundException, IOException {
		HashMap<Integer, ArrayList<Consumo>>  xd = infoHotel.GetConsumos();
		System.out.println("Habitaciones con registros de consumo: " );
		for (HashMap.Entry<Integer,  ArrayList<Consumo>> entry : xd.entrySet()) {
		    System.out.println("Habitación N.o: " + entry.getKey() );
		}
		
	}
	public void ObtenerHuespedes() throws ClassNotFoundException, IOException {
		Collection<Huesped> inventario = infoHotel.getHuespedes().values();
		for (Huesped element:inventario) {
			System.out.print(element.getNumero());
			System.out.print("    ");
			
		}
		
	}
	
	
		public void EliminarHabitacion(int numeroHabitacion) throws IOException, ClassNotFoundException {
			infoHotel.eliminarObjeto(numeroHabitacion); ;
		}
		public void eliminar_ser_pro ( )throws ClassNotFoundException, IOException {
			System.out.print("--CÁTALOGO DE SERVICIOS--");
	 		System.out.print("\n");
	 		obtenerServicios();
	 		System.out.print("--MENÚ DEL RESTAURANTE--");
	 		System.out.print("\n");
	 		obtenerMenu();
			String nombre =(input("Me podrías dar el nombre del servicio o producto"));
			infoHotel.eliminar_ser_pro(nombre);
		}
		
		public void GuardarObjeto(int precio, int numero) throws ClassNotFoundException, IOException {
			infoHotel.GuardarrObjeto(precio, numero);
		}
		public void objetoGuardar (String tipo, ArrayList<String> dias, String horas, int valor, String nombre) throws ClassNotFoundException, IOException {
			infoHotel.guardarObjeto( tipo,  dias,  horas,  valor,  nombre);
		}
		private void abrir_consumo() throws ClassNotFoundException, IOException {
			obtener_consumo_por_habitacion();
			int numero_hab = Integer.parseInt(input("Me podrías dar el número de la habitación pls"));
			infoHotel.abrir_registro_consumo(numero_hab);
		}
		private void modificar_consumo() throws ClassNotFoundException, IOException {
			obtener_consumo_por_habitacion();
			System.out.print("--CÁTALOGO DE SERVICIOS--");
	 		System.out.print("\n");
	 		obtenerServicios();
	 		System.out.print("--MENÚ DEL RESTAURANTE--");
	 		System.out.print("\n");
	 		obtenerMenu();
	 		
			int numero_hab = Integer.parseInt(input("Me podrías dar el número de la habitación pls"));
			System.out.print("Registro de Consumo actual");
			obtener_consumo(numero_hab);
	 		String consumo_servicio = (input("Me podrías dar el nombre del servicio a añadir"));
	 		boolean pagado= Boolean.parseBoolean(input("Me podrías dar indicar si el servicio está pago o no, gracias."));
			infoHotel.modificar_registro_consumo(numero_hab,consumo_servicio,pagado);
		}
		private void eliminar_consumo() throws ClassNotFoundException, IOException {
			obtener_consumo_por_habitacion();
			int numero_hab = Integer.parseInt(input("Me podrías dar el número de la habitación pls"));
			infoHotel.eliminar_registro_consumo(numero_hab);
		}
		public void crear_servicio() throws ClassNotFoundException, IOException {
			System.out.println("1. Crear un servicio por escritura");
			System.out.println("2. Crear un servicio por lectura de un archivo .txt");
			String consumo_servicio = (input("Elige una :D : "));
			if (consumo_servicio.equalsIgnoreCase("1")) {
				String nombre =(input("Me podrías dar el nombre del servicio"));
				int precio = Integer.parseInt(input("Me podrías dar el precio del servicio"));
				System.out.print("Lunes: L. Martes: M. Miércoles: X. Jueves: J. Viernes: V. Sábado: S. Domingo: D.");
		 		System.out.print("\n");
				String diasinput =(input("Me podrías dar los días a la semana (separados por -) Ej: L-V-D"));
				String tipo = "Servicio";
				String horario =(input("Me podrías dar el horaio de disponibilidad (sobre 24 hrs) Ej: 01-13"));
				infoHotel.crear_servicio(tipo, diasinput, horario, precio, nombre);
			}else {
				String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (sernuevo.txt)"));
				String ruta = new String("./data/");
				String entrada= ruta;
			    entrada+=archivo;
				System.out.println(entrada);
				infoHotel.crear_servicio_file(entrada);
			}
		}
		public void editar_tarifa_servicio () throws ClassNotFoundException, IOException {
			System.out.println("1. Editar un servicio por escritura");
			System.out.println("2. Editar un servicio por lectura de un archivo .txt");
			String consumo_servicio = (input("Elige una :D : "));
			if (consumo_servicio.equalsIgnoreCase("1")) {
				System.out.print("--CÁTALOGO DE SERVICIOS--");
		 		System.out.print("\n");
		 		obtenerServicios();
				String nombre =(input("Me podrías dar el nombre del servicio"));
				int precio = Integer.parseInt(input("Me podrías dar el nuevo precio del servicio"));
				infoHotel.editar_servicio(precio, nombre);
			}else {
				String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (serprecios.txt)"));
				String ruta = new String("./data/");
				String entrada= ruta;
			    entrada+=archivo;
				System.out.println(entrada);
				infoHotel.editar_servicio_file(entrada);
			}
		}
		public void crear_producto() throws ClassNotFoundException, IOException {
			System.out.println("1. Crear un producto por escritura");
			System.out.println("2. Crear un producto por lectura de un archivo .txt");
			String consumo_servicio = (input("Elige una :D : "));
			if (consumo_servicio.equalsIgnoreCase("1")) {
				String nombre =(input("Me podrías dar el nombre del producto"));
				int precio = Integer.parseInt(input("Me podrías dar el precio del producto"));
				System.out.print("Lunes: L. Martes: M. Miércoles: X. Jueves: J. Viernes: V. Sábado: S. Domingo: D.");
		 		System.out.print("\n");
				String diasinput =(input("Me podrías dar los días a la semana (separados por -) Ej: L-V-D"));
				String tipo = "Servicio";
				String horario =(input("Me podrías dar el horaio de disponibilidad (sobre 24 hrs) Ej: 01-13"));
				String disptipo =(input("Me podrías dar la disponibilidad del prodcuto (Comedor, Habitación)"));
				String consutipo =(input("Me podrías dar la disponibilidad de la comida (Permanente, Desayuno, Almuerzo, Cena)"));
				infoHotel.crear_producto(tipo, diasinput, horario, precio, nombre, consutipo, disptipo);
			}else {
				String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (pronuevo.txt)"));
				String ruta = new String("./data/");
				String entrada= ruta;
			    entrada+=archivo;
				System.out.println(entrada);
				infoHotel.crear_producto_file(entrada);
			}
		}
		public void editar_tarifa_producto () throws ClassNotFoundException, IOException {
			System.out.println("1. Editar un producto por escritura");
			System.out.println("2. Editar un producto por lectura de un archivo .txt");
			String consumo_servicio = (input("Elige una :D : "));
			if (consumo_servicio.equalsIgnoreCase("1")) {
				System.out.print("--MENÚ DEL RESTAURANTE--");
		 		System.out.print("\n");
		 		obtenerMenu();
				String nombre =(input("Me podrías dar el nombre del producto"));
				int precio = Integer.parseInt(input("Me podrías dar el nuevo precio del producto"));
				infoHotel.editar_producto(precio, nombre);
			}else {
				String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (proprecios.txt)"));
				String ruta = new String("./data/");
				String entrada= ruta;
			    entrada+=archivo;
				System.out.println(entrada);
				infoHotel.editar_producto_file(entrada);
			}
		}
		public void mostrarMenu()
		{
			System.out.println("\nOpciones de la aplicación\n");
			System.out.println("1. Administrador");
			System.out.println("2. Recepcionista");
			System.out.println("3. Empleado");
			System.out.println("4. Salir de la aplicación\n");
		}
		public void mostrarMenu_admin()
		{
			System.out.println("\nOpciones de la aplicación\n");
			
			System.out.println("1. Abrir un registro de Consumo");
			System.out.println("2. Modificar un registro de Consumo");
			System.out.println("3. Eliminar un registro de Consumo");
			System.out.println("4. Salir de la aplicación\n");
		}
		public void mostrarMenu_empleado()
		{
			System.out.println("\nOpciones de la aplicación\n");
			
			System.out.println("1. Crear Servicio");
			System.out.println("2. Editar Tarifa de un Servicio");
			System.out.println("3. Crear Producto del Menú");
			System.out.println("4. Editar Tarifa de un producto del Menú");
			System.out.println("5. Eliminar un servicio o producto");
			System.out.println("6. Salir de la aplicación\n");
		}
}