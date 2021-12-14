package main;

import java.util.Scanner;

import test.CRUD;

public class Main {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		boolean salir = false;
		int num;
		String frase;
		 CRUD crud1 = new CRUD();
		while (!salir) {
			System.out.println("Escriba un número del 1 al 4");

			System.out.println("1. Introducir Vehículo");
			System.out.println("2. Mostrar Vehículos");
			System.out.println("3. Borrar Vehículos ");
			System.out.println("4. Modificar Vehículos");
			System.out.println("5. Salir");
			num = leer.nextInt();
			
			switch (num) {
			case 1:
				System.out.println("Esbriba id, marca, modolelo y Kilometros");
				System.out.println("Id:");
				int id1 = leer.nextInt();
				System.out.println("Marca:");
				String marca = leer.next();
				System.out.println("Modelo:");
				String modelo = leer.next();
				System.out.println("Kilometros:");
				int km = leer.nextInt();
				crud1.Insertar(id1, marca, modelo, km);
				break;
			case 2:
				crud1.Leer();
				break;
			case 3:
				System.out.println("Escriba el id de un Vehículo para eliminarlo");
				System.out.println("Para ello primero mostraremos los vehículos");
				crud1.Leer();
				System.out.println("Escriba id:");
				int id = leer.nextInt();
				crud1.Borrar(id);
				crud1.Leer();
				break;
			case 4:
				System.out.println("Ahora usted va a modificar eliga un id");
				crud1.Leer();
				System.out.println("Escriba id a modificar:");
				int id2 =leer.nextInt();
				System.out.println("Marca:");
				String marca2 = leer.next();
				System.out.println("Modelo:");
				String modelo2 = leer.next();
				System.out.println("Kilometros:");
				int km2 = leer.nextInt();
				crud1.Actualizar(marca2, modelo2, km2, id2);
				break;
			case 5:
				System.out.println("Usted se ha salido");
				salir = true;
				break;
			default:
				System.out.println("Solo números entre 1 y 4");
				num = leer.nextInt();
			}
		}
	}
}
