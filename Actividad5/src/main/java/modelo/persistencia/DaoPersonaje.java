package modelo.persistencia;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Personaje;
import modelo.entidad.Videojuego;

public class DaoPersonaje {
	
	private EntityManager em;
	public Scanner sc = new Scanner(System.in);

	public boolean abrirConexion() {
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
			em = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean cerrarConexion() {
		try {
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean altaPersonaje(String nombre, String color) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		Personaje personaje = new Personaje();
		personaje.setNombre(nombre);
		personaje.setColor(color);

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(personaje);
		et.commit();

		System.out.println("Personaje creado con ID : " + personaje.getId());
		cerrarConexion();

		return alta = true;
	}

	public boolean bajaPersonaje(Integer id) {
		if (!abrirConexion()) {
			return false;
		}
		boolean baja = true;
		Personaje personaje = em.find(Personaje.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(personaje);
		et.commit();

		System.out.println("Personaje Borrado");

		/*
		List<Personaje> listaPersonajes = em.createQuery("from Personaje").getResultList();
		for (Personaje c : listaPersonajes) {
			System.out.println(c);
		}*/
		cerrarConexion();
		System.out.println("Fin de borrar Personaje");
		return baja;
	}

	public boolean buscarPersonajeID(Integer id) {
		if (!abrirConexion()) {
			return false;
		}
		boolean buscar = true;
		Personaje personaje = em.find(Personaje.class, id);
		System.out.println(personaje);

		System.out.println("Fin de mostrar Personaje");
		return buscar;
	}

	@SuppressWarnings("unchecked")
	public List<Personaje> listarPersonaje() {
		if (!abrirConexion()) {
			return null;
		}

		EntityTransaction et = em.getTransaction();
		et.begin();
		et.commit();

		List<Personaje> listaPersonajes = em.createQuery("from Personaje").getResultList();
		
		/*for (Personaje v : listaPersonajes) {
			System.out.println(v);
			cerrarConexion();

		}*/
		return listaPersonajes;
	}

	public boolean asociarPersonajeVideojuego() {
		if (!abrirConexion()) {
			return false;
		}
		
		boolean asociar = true;
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		/*
		System.out.println("Lista Personaje");
		List<Personaje> listaPersonaje = em.createQuery("from Personaje").getResultList();
		for (Personaje p : listaPersonaje) {
			System.out.println(p);
			

		}

		System.out.println("Lista videojuegos");
		List<Videojuego> listaVideojuegos = em.createQuery("from Videojuego").getResultList();
		for (Videojuego v : listaVideojuegos) {
			System.out.println(v);
			
		}*/
		
		//Esto debería ir en la vista
		System.out.println("Introduce la id del personaje al que quieras asociar un videojuego");
		Integer idp = Integer.parseInt(sc.nextLine());
		Personaje personaje = em.find(Personaje.class, idp);
		
		System.out.println("Introduce el id del videojuego al que quieras asociar un personaje");
		Integer id = Integer.parseInt(sc.nextLine());
		Videojuego videojuego = em.find(Videojuego.class, id);
		
		
		personaje.setVideojuego(videojuego);
		System.out.println(personaje);
		em.merge(personaje);
		et.commit();
		
		cerrarConexion();
		
		return asociar;
	}
	
	
}
