package utn.frsf.died.guia05.p1;

import java.util.List;
import java.util.Scanner;

public class App {
	private static Camino camino = new Camino();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		generarCoordenadasRandom();
		menu();
	}

	private static void menu() {

		System.out.println("Bienvenido al gestor de caminos");
		System.out.println("Ingrese la opción que desee");
		System.out.println("1-Listar Coordenadas");
		System.out.println("2-Agregar Coordenadas");
		System.out.println("3-Agregar Punto por Distancia");
		System.out.println("4-Buscar coordenadas dentro de un radio");
		System.out.println("5-Buscar coordenadas en región");
		System.out.println("0-Salir");
		
		var reader = new Scanner(System.in);
		
		System.out.println("Opcion: ");
		
		int opc = reader.nextInt();
		reader.reset();
		switch(opc) {
		case 1:
			listarCaminos();
			break;
		case 2:
			agregarCoordenada();
			break;
		case 3:
			agregarPuntoMt();
			break;
		case 4:
			buscarEnRadio();
			break;
		case 5:
			buscarEnRegion();
			break;
		case 0:
			break;
			default:
				System.out.println("Opcion Invalida. Vuelva a intentar.");
				menu();
				break;				
		}
		
	}
	private static void buscarEnRegion() {
	var reader = new Scanner(System.in);
		
		System.out.println("A continuación ingrese los datos del punto NO");
		System.out.println("Longitud:");
		int noLn = reader.nextInt();
		reader.reset();
		

		System.out.println("Latitud");
		int noLt = reader.nextInt();
		reader.reset();		

		System.out.println("A continuación ingrese los datos del punto NO");
		System.out.println("Longitud:");
		int seLn = reader.nextInt();
		reader.reset();		

		System.out.println("Latitud");
		int seLt = reader.nextInt();
		reader.reset();
		
		Coordenada ptoNo = new Coordenada(noLt,noLn);
		Coordenada ptoSe = new Coordenada(seLt,seLn);
		
		List<Coordenada> res = camino.buscar(ptoNo, ptoSe);
		
		if(res.size()==0) {
			System.out.println("No se encontraron coordenadas en la región indicada.");

		}else {
			System.out.println("Se encontraron " + res.size() + " coordenadas en la región indicada.");
			for(Coordenada c : res) {
				System.out.println(c.toString());
			}
		}
		System.out.println("Presione enter para continuar.");
		reader.nextLine();
		menu();
	}

	private static void agregarPuntoMt() {
		var reader = new Scanner(System.in);
		
		System.out.println("Metros desde la longitud: ");
		int lon = reader.nextInt();
		reader.reset();
		
		System.out.println("Metros desde la latitud: ");
		int lat = reader.nextInt();
		reader.reset();
		
		var coordenadas = camino.getCoordenadas();
		
		var punto = coordenadas.get(coordenadas.size()-1);
		
		var nuevoPunto = punto.mover(lat, lon);
		camino.agregar(nuevoPunto);
		
		System.out.println("Se agrego el punto ");
		System.out.println(nuevoPunto.toString());
		
		System.out.println("Presione enter para continuar.");
		reader.nextLine();
		menu();
		
	}

	private static void agregarCoordenada() {

		var reader = new Scanner(System.in);
		
		System.out.println("Longitud: ");
		
		double lon = reader.nextDouble();
		reader.reset();
		
		System.out.println("Latitud: ");
		double lat = reader.nextDouble();
		
		reader.reset();
		
		Coordenada punto = new Coordenada(lat, lon);
		camino.agregar(punto);
		
		System.out.println("Agregada coordenada");
		System.out.println(punto.toString());
		System.out.println("Presione enter para continuar.");
		reader.nextLine();
		menu();
		
	}
	
	
	private static void listarCaminos() {

		List<Coordenada> coord = camino.getCoordenadas();
		
		if(coord.size()==0) {			
			System.out.println("No hay coordenadas cargadas");
		}else {
			for(Coordenada c : camino.getCoordenadas()) {
				System.out.println(c.toString());
			
			}
		}
		System.out.println("Presione enter para continuar.");
		
		var reader = new Scanner(System.in);
		reader.nextLine();
		
		menu();
	}
	
	private static void buscarEnRadio() {
		System.out.println("Se buscarán las coordenadas incluidas en el radio alrededor");
		System.out.println("del punto que debe brindar a continuación.");
		System.out.println("");
		
		var reader = new Scanner(System.in);

		System.out.println("Longitud del punto:");
		reader.reset();
		double lon = reader.nextDouble();
		
		System.out.println("Latitud del punto:");
		reader.reset();
		double lat = reader.nextDouble();
		
		
		System.out.println("Distancia en metros:");
		reader.reset();
		double mt = reader.nextInt();
		reader.reset();

		Coordenada cor = new Coordenada(lat,lon);
		System.out.println("Se buscara en el punto:");
		System.out.println(cor.toString());
		System.out.println("A " + mt + "metros del punto.");
		
		var res = camino.buscar(cor,mt);
		if(res.size() == 0) {
			System.out.println("No se encontraron puntos en el radio indicado.");			
		}else {
			System.out.println("Se encontraron " + res.size() + " puntos en el area solicitada.");
			
			for(Coordenada punto : res) {
				System.out.println(punto.toString());				
			}
		}
		
		System.out.println("Presione enter para continuar.");
		reader.nextLine();
		menu();
	}
	
	private static void generarCoordenadasRandom() {
		int i = 0;
		
		while(i<20) {
			double lat = Math.random()*90;
			double lon = Math.random()*180;
			
			switch(i%4) {
			case 0:
				break;
			case 1:
				lat = -lat;
				break;
			case 2:
				lon= -lon;
				break;
			case 3:
				lon= -lon;
				lat = -lat;
				default:
					break;
			}
			
			camino.agregar(new Coordenada(lat,lon));
			i++;
		}
	}
	
}
