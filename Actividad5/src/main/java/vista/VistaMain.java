package vista;

import java.util.Scanner;

import modelo.negocio.GestorPersonaje;
import modelo.negocio.GestorVideojuego;


public class VistaMain {
	
	static GestorVideojuego gVideojuegos = new GestorVideojuego();
	static GestorPersonaje gPersonaje = new GestorPersonaje();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean continuar = true;

		while (continuar) {

			System.out.println("1 - Gestion de videojuego ");
			System.out.println("2 - Gestion de personaje ");
			System.out.println("0 - Salir de la app ");

			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
			case 1:
				preguntarVideojuego();
				break;

			// Aqui empieza el caso 2
			case 2:
				preguntarPersonaje();
				break;

			// Aqui empieza el caso 0
			case 0:
				System.out.println("Has salido de la app");
				continuar = false;
				break;

			default:
				System.out.println("Solo números 1,2,0 ");

				System.out.println("Debes introducir el mismo número");
				sc.next();// Evita un bucle infinito en el scanner
				break;

			}
		}
	}

	public static void preguntarVideojuego() {

		System.out.println("1. Alta videojuego ");
		System.out.println("2. Baja Videojuego ");
		System.out.println("3. Buscar Videojuego por ID ");
		System.out.println("4. Listar Videojuego ");
		System.out.println("5. Asociar videojuego a Personaje ");

		System.out.println("Escribe una opción");
		int option = Integer.parseInt(sc.nextLine());

		switch (option) {
		case 1:
			System.out.println("Alta videojuego");
			System.out.println("Por favor introduzca el nombre");
			String nombre = sc.nextLine();
			System.out.println("Por favor introduzca la compañia");
			String company = sc.nextLine();
			System.out.println("Por favor introduzca la nota");
			Integer nota = Integer.parseInt(sc.nextLine());
			gVideojuegos.altaVideojuego(nombre, company, nota);
			break;

		case 2:
			System.out.println("Baja Videojuego");
			System.out.println("Por favor introduzca el ID");
			Integer id = Integer.parseInt(sc.nextLine());
			gVideojuegos.bajaVideojuegoID(id);
			break;

		case 3:
			System.out.println("Buscar Videojuego por ID");
			id = Integer.parseInt(sc.nextLine());
			gVideojuegos.buscarVideojuego(id);
			break;

		case 4:
			System.out.println("Listar Videojuegos");
			gVideojuegos.listarVideojuego();
			break;

		case 5:
			System.out.println("Asociar Videojuego a Personaje");
			//Aqui habria que recoger los datos del videojuego
			//y pasarlos al gestor
			gVideojuegos.asociarVideojuegoPersonaje();
			break;

		default:
			System.out.println("Solo números entre 1 y 5 ");

			System.out.println("Debes introducir el mismo número");
			sc.next();// Evita un bucle infinito en el scanner
			break;
		}
	}

	public static void preguntarPersonaje() {

		System.out.println("1. Alta Personaje ");
		System.out.println("2. Baja Personaje ");
		System.out.println("3. Buscar Personaje por ID ");
		System.out.println("4. Listar Personaje ");
		System.out.println("5. Asociar Personaje a Videojuego ");

		System.out.println("Escribe una opción");
		int option = Integer.parseInt(sc.nextLine());

		switch (option) {
		case 1:
			System.out.println("Alta Personaje");
			System.out.println("Por favor introduzca el nombre");
			String nombre = sc.nextLine();
			System.out.println("Por favor introduzca el color");
			String color = sc.nextLine();
			gPersonaje.altaPersonaje(nombre, color);
			break;

		case 2:
			System.out.println("Baja Personaje");
			System.out.println("Por favor introduzca el ID");
			Integer id = Integer.parseInt(sc.nextLine());
			gPersonaje.bajaPersonaje(id);
			break;

		case 3:
			System.out.println("Buscar Personaje por ID");
			id = Integer.parseInt(sc.nextLine());
			gPersonaje.buscarPersonajeID(id);
			break;

		case 4:
			System.out.println("Listar Personaje");
			gPersonaje.listarPersonaje();
			break;

		case 5:
			System.out.println("Asociar Videojuego a Personaje");
			//Idem que en videojuego
			gPersonaje.asociarPersonajeVideojuego();
			break;

		default:
			System.out.println("Solo números entre 1 y 5 ");

			System.out.println("Debes introducir el mismo número");
			sc.next();// Evita un bucle infinito en el scanner
			break;
		}
	}
}
