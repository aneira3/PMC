package modelo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	private static Servicio service=new Servicio("Alojamineto",null,null,8002,"Alojamiento");
	private static Producto product=new Producto("Alojamineto",null,null,8002,"Alojamiento",null,null);
 public static void main(String[] args) throws FileNotFoundException, IOException {
	String ruta = new String("C://Users//Juan Esteban//Desktop//ANDES//2023-10//DPO//Persistencia//data/");

	
	 
	//xd.txt
	//String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (sernuevo.txt)"));
	//String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (serprecios.txt)"));
	//String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (pronuevo.txt)"));
	String archivo=(input("Me puedes dar el nombre del archivo a cargar plss (proprecios.txt)"));
	String entrada= ruta;
	entrada+=archivo;
	System.out.println(entrada);
	
	//service.crear_servicio_file(entrada);
	//service.editar_servicio_file(entrada);
	//service.editar_servicio(3456, "sdf");
	//product.crear_producto_file(entrada);
	//product.editar_producto(3456, "sdf");
	//product.editar_producto_file(entrada);
	ArrayList<String> dias=new ArrayList<String>();
	dias.add("L");
	Servicio xd=new Servicio("Servicio", dias, "si", 45678, "sd");
	Producto xd1=new Producto("Restaurante", dias, "s", 0, "e", "e", "e");
	//product.crear_producto("Restaurante", "L-X-S", "s", 0, "PAPAS", "e", "e");
	if ((xd.getClass()).equals(xd1.getClass())) {
		System.out.println("si");
	}else {
		System.out.println("no");
	}
 }
	public static String input(String mensaje)
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

}
