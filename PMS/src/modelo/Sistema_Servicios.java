package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sistema_Servicios implements Serializable{
	//private Habitacion habitacion;
	
	//private RegistroConsumo consumo;
	BaseDatos datos = new BaseDatos();
	public Sistema_Servicios() {
		
	}
	public void crear_servicio (String tipo,  String dias, String horario, int valor, String nombre) throws ClassNotFoundException, IOException {
		String tipo_service="Servicio";
			
		
		String [] arr= dias.split(",");
		ArrayList<String> arrayDias= new ArrayList<String>(Arrays.asList(arr));
		//Crear servicio a partir de ciertos "atributos" escritos en consola
		Servicio service= new Servicio(tipo_service, arrayDias, horario, valor, nombre);
		//abrir base de datos servicio
		//ArrayList<Servicio> lista=new  ArrayList<Servicio>();
		//lista.add(service);
		Map<String, Servicio > mapa =datos.GetServicios();//abrir base de datos
		if (mapa.containsKey(service.getNombre())) {
			//si existe la llave, entonces nada; pues ESTE método es de crear no actualizar
			System.out.println("Ya existe un servicio con el nombre "+service.getNombre()+", si quieres modificar su tarifa elige la opción que necesites ya sea por archivo o no");
		}else {
			//si este no existe, debo añadirlo al mapa, y hacer un primer registro que es el precio de la estadía
			datos.GuardarObjeto(service);
			
			System.out.println("Se ha creado un servicio de tipo "+tipo_service+" con el nombre: " + service.getNombre() );
		}
	}
	public void editar_servicio(int valor, String key)throws ClassNotFoundException, IOException {
		//abrir base de datos servicio
		//RECUERDA QUE ESTÁ OPCIÓN ES SOLO PARA MODIFICAR 1 SOLO SERVICIO
 		Map<String, Servicio > mapa = datos.GetServicios();
 		//ArrayList<String> dias=new ArrayList<String>();
 		//dias.add("L");
 		//Servicio xd=new Servicio("Servicio", dias, "si", 45678, key);
 		//mapa.put(key, xd);
 		if (mapa.containsKey(key)) {
 			Servicio keyvalue=mapa.get(key);
 			System.out.println("El servicio " + key + " se ha modificado" );
 			System.out.println("Precio Anterior: " + keyvalue.getValor());
 			//System.out.print(keyvalue.toString());
 			System.out.print("\n");
 			keyvalue.setPrecio(valor);
 			System.out.println("Precio Nuevo: " + keyvalue.getValor());
 			//System.out.print(keyvalue.toString());
 			System.out.print("\n");
 			datos.GuardarObjeto(keyvalue);
 			//guardar base de datos

 		}else {
			//si este no existe, debo añadirlo al mapa, y hacer un primer registro que es el precio de la estadía
 			System.out.println("El servicio "+key +" no está registrado en la base de datos. TIP: trata de editar un servicio existente" );
		}
	}
	public void crear_servicio_file (String ruta) throws FileNotFoundException, IOException {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null) {
	           //System.out.println(linea);
	         if (linea!=null) {
	        	 String [] arr= linea.split(",");
		 		ArrayList<String> lista= new ArrayList<String>(Arrays.asList(arr));
		 		//1
		 		String tipo=lista.get(0);
		 		if (tipo.equals("servicio")) {
		 			//2
		 			int xd=1;
		 			String [] arreglo= lista.get(1).split("-");
			 		ArrayList<String> dias= new ArrayList<String>(Arrays.asList(arreglo));
			 		//3
			 		String horario = lista.get(2);
			 		//4
			 		int valor = Integer.parseInt(lista.get(3));
			 		//5
			 		String nombre = lista.get(4);
			 		//System.out.println(tipo+dias+horario+valor+nombre);
			 		//ya tengo almacenado cada atributo de la línea de código
			 		//abrir base de datos servicio
			 		Map<String, Servicio > mapa = datos.GetServicios();
			 		//valuekey
			 		Servicio valuekey = new Servicio(tipo, dias, horario, valor, nombre);
			 		//llave
			 		System.out.println(valuekey.getNombre());
			 		String key= valuekey.getNombre();
			 		if (mapa.containsKey(key)) {
			 			System.out.println("Ya existe un servicio con este nombre, si quieres modificar su tarifa elige la opción que necesites ya sea por archivo o no");
			 		}else {
			 			//guardar base de datos
			 			datos.GuardarObjeto(valuekey);
			 			System.out.println("Se ha creado un servicio de tipo "+tipo+" con el nombre: " + key );
			 			//System.out.println(valuekey.getValor());
			 			//int nmma =1234;
			 			//valuekey.setValor(nmma);
			 			//System.out.println(valuekey.getValor());
			 		}

		 		} else {
		 			break;
		 		}
	         }
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	   }
	public void editar_servicio_file( String ruta) throws FileNotFoundException, IOException {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null) {
	           System.out.println(linea);
	         if (linea!=null) {
	        	 String [] arr= linea.split(",");
		 		ArrayList<String> lista= new ArrayList<String>(Arrays.asList(arr));
		 		//1
		 		String nombre=lista.get(0);
		 		int valor = Integer.parseInt(lista.get(1));
			 		//abrir base de datos servicio
			 		Map<String, Servicio > mapa =  datos.GetServicios();
			 		if (mapa.containsKey(nombre)) {
			 			Servicio keyvalue=mapa.get(nombre);
			 			System.out.println("El servicio " + nombre + " se ha modificado" );
			 			System.out.println("Precio Anterior: " + keyvalue.getValor());
			 			//System.out.print(keyvalue.toString());
			 			System.out.print("\n");
			 			keyvalue.setPrecio(valor);
			 			System.out.println("Precio Nuevo: " + keyvalue.getValor());
			 			//guardar base de datos
			 			//System.out.print(keyvalue.toString());
			 			System.out.print("\n");
			 			datos.GuardarObjeto(keyvalue);
			 		}else {
			 			System.out.println("El servicio "+nombre +" no está registrado en la base de datos. TIP: trata de editar un servicio existente" );
			 		}	
	         }
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	public void crear_producto (String tipo,  String dias, String horario, int valor, String nombre, String dispoComi, String dispoTipo) throws ClassNotFoundException, IOException {
		String tipo_service="Restaurante";
		
		String [] arr= dias.split(",");
		ArrayList<String> arrayDias= new ArrayList<String>(Arrays.asList(arr));
		//Crear servicio a partir de ciertos "atributos" escritos en consola
		Producto service= new Producto(tipo_service, arrayDias, horario, valor, nombre, dispoComi,dispoTipo);
		//abrir base de datos servicio
		//ArrayList<String> lista=new  ArrayList<String>();
		//lista.add("L");
		Map<String, Producto > mapa = datos.GetMenu(); //abrir base de datos
		
		//Producto cositas= new Producto("Restaurante", lista, "s", 0, "PAPAS", "e", "e");
		//mapa.put(nombre, cositas);
		if (mapa.containsKey(service.getNombre())) {
			//si existe la llave, entonces nada; pues ESTE método es de crear no actualizar
			System.out.println("Ya existe un Producto del restaurante con el nombre "+service.getNombre()+", si quieres modificar su tarifa elige la opción que necesites ya sea por archivo o no");
		}else {
			//si este no existe, debo añadirlo al mapa, y hacer un primer registro que es el precio de la estadía
			
			datos.GuardarObjeto(service);
			System.out.println("Se ha creado un producto con el nombre: " + service.getNombre() );
		}
	}
	public void editar_producto(int valor, String key) throws ClassNotFoundException, IOException {
		//abrir base de datos servicio
		//RECUERDA QUE ESTÁ OPCIÓN ES SOLO PARA MODIFICAR 1 SOLO SERVICIO
 		Map<String, Producto > mapa = datos.GetMenu();
 		//ArrayList<String> dias=new ArrayList<String>();
 		//dias.add("L");
 		//Producto xd=new Producto("Servicio", dias, "si", 45678, key,"xd2","dd");
 		//mapa.put(key, xd);
 		if (mapa.containsKey(key)) {
 			Producto keyvalue=mapa.get(key);
 			System.out.println("El servicio " + key + " se ha modificado" );
 			System.out.println("Precio Anterior: " + keyvalue.getValor());
 			keyvalue.setPrecio(valor);
 			System.out.println("Precio Nuevo: " + keyvalue.getValor());
 			//guardar base de datos
 			datos.GuardarObjeto(keyvalue);
 		}else {
			//si este no existe, debo añadirlo al mapa, y hacer un primer registro que es el precio de la estadía
 			System.out.println("El servicio " + key+" no está registrado en la base de datos. TIP: trata de editar un servicio existente" );
		}
	}
	public void crear_producto_file (String ruta) throws FileNotFoundException, IOException {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null) {
	           System.out.println(linea);
	         if (linea!=null) {
	        	 String [] arr= linea.split(",");
		 		ArrayList<String> lista= new ArrayList<String>(Arrays.asList(arr));
		 		//1
		 		String tipo=lista.get(0);
		 		if (tipo.equals("restaurante")) {
		 			//2
		 			int xd=1;
		 			String [] arreglo= lista.get(1).split("-");
			 		ArrayList<String> dias= new ArrayList<String>(Arrays.asList(arreglo));
			 		//3
			 		String horario = lista.get(2);
			 		//4
			 		int valor = Integer.parseInt(lista.get(3));
			 		//5
			 		String nombre = lista.get(4);
			 		//6
			 		String comida=lista.get(5);
			 		//7
			 		String tipocomida=lista.get(6);
			 		//System.out.println(tipo+dias+horario+valor+nombre+comida+tipocomida);
			 		//ya tengo almacenado cada atributo de la línea de código
			 		//abrir base de datos servicio
			 		Map<String, Producto > mapa = datos.GetMenu();
			 		//valuekey
			 		Producto valuekey = new Producto(tipo, dias, horario, valor, nombre,comida,tipocomida);
			 		//llave
			 		String key= valuekey.getNombre();
			 		if (mapa.containsKey(key)) {
			 			System.out.println("Ya existe un servicio con el nombre "+key+", si quieres modificar su tarifa elige la opción que necesites ya sea por archivo o no");
			 		}else {
			 			//guardar base de datos
			 			datos.GuardarObjeto(valuekey);
			 			System.out.println("Se ha creado un producto con el nombre: " + key );
			 			//System.out.println(valuekey.getValor());
			 			//int nmma =1234;
			 			//valuekey.setValor(nmma);
			 			//System.out.println(valuekey.getValor());
			 		}

		 		} else {
		 			break;
		 		}
	         }
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	   }
	public void editar_producto_file( String ruta) throws FileNotFoundException, IOException {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null) {
	           System.out.println(linea);
	         if (linea!=null) {
	        	 String [] arr= linea.split(",");
		 		ArrayList<String> lista= new ArrayList<String>(Arrays.asList(arr));
		 		//1
		 		String nombre=lista.get(0);
		 		int valor = Integer.parseInt(lista.get(1));
			 		//abrir base de datos servicio
			 		Map<String, Producto > mapa = datos.GetMenu();
			 		ArrayList<String> dias=new ArrayList<String>();
			 		//dias.add("L");
			 		//Producto xd=new Producto("Restaurante", dias, "si", 45678, "jugo de maracuya","xd2","dd");
			 		//mapa.put("jugo de maracuya", xd);
			 		//Producto xd1=new Producto("Restaurante", dias, "si", 45678, "tostadas francesas","xd2","dd");
			 		//mapa.put("tostadas francesas", xd1);
			 		if (mapa.containsKey(nombre)) {
			 			Producto keyvalue=mapa.get(nombre);
			 			System.out.println("El servicio " + nombre + " se ha modificado" );
			 			System.out.println("Precio Anterior: " + keyvalue.getValor());
			 			keyvalue.setPrecio(valor);
			 			System.out.println("Precio Nuevo: " + keyvalue.getValor());
			 			//guardar base de datos
			 			datos.GuardarObjeto(keyvalue);
			 		}else {
			 			System.out.println("El producto "+nombre +" no está registrado en la base de datos. TIP: trata de editar un producto existente" );
			 		}	
	         }
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
}
