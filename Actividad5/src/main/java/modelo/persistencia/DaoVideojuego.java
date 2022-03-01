package modelo.persistencia;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Personaje;
import modelo.entidad.Videojuego;

public class DaoVideojuego {

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

	public boolean altaVideojuego(String nombre, String company, Integer nota) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		Videojuego videojuego = new Videojuego();
		videojuego.setNombre(nombre);
		videojuego.setCompany(company);
		videojuego.setNota(nota);

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(videojuego);
		et.commit();

		System.out.println("Videojuego creado con ID : " + videojuego.getId());
		cerrarConexion();

		return alta = true;
	}

	public boolean bajaVideojuego(Integer id) {
		if (!abrirConexion()) {
			return false;
		}
		boolean baja = true;
		Videojuego videojuego = em.find(Videojuego.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(videojuego);
		et.commit();

		System.out.println("Videojuego Borrado");

		List<Videojuego> listaVideojuegos = em.createQuery("from Videojuego").getResultList();
		for (Videojuego c : listaVideojuegos) {
			System.out.println(c);
		}
		cerrarConexion();
		System.out.println("Fin de borrar Videojuego");
		return baja;
	}

	public boolean buscarVideojuegoID(Integer id) {
		if (!abrirConexion()) {
			return false;
		}
		boolean buscar = true;
		Videojuego videojuego = em.find(Videojuego.class, id);
		System.out.println(videojuego);
		System.out.println("Fin de mostrar coche");
		return buscar;
	}

	@SuppressWarnings("unchecked")
	public List<Videojuego> listarVideojuego() {
		if (!abrirConexion()) {
			return null;
		}

		EntityTransaction et = em.getTransaction();
		et.begin();
		et.commit();

		List<Videojuego> listaVideojuegos = em.createQuery("from Videojuego").getResultList();
		for (Videojuego v : listaVideojuegos) {
			System.out.println(v);
			cerrarConexion();

		}
		return listaVideojuegos;
	}

	public boolean asociarVideojuegoPersonaje() {
		if (!abrirConexion()) {
			return false;
		}
		
		boolean asociar = true;
		EntityTransaction et = em.getTransaction();
		et.begin();
		

		System.out.println("Lista videojuegos");
		List<Videojuego> listaVideojuegos = em.createQuery("from Videojuego").getResultList();
		for (Videojuego v : listaVideojuegos) {
			System.out.println(v);
		}
		
		System.out.println("Lista Personaje");
		List<Personaje> listaPersonaje = em.createQuery("from Personaje").getResultList();
		for (Personaje p : listaPersonaje) {
			System.out.println(p);
		}
		
		//Esto iria en la vista
		System.out.println("Introduce el id del videojuego al que quieras asociar un personaje");
		Integer id = Integer.parseInt(sc.nextLine());
		Videojuego videojuego = em.find(Videojuego.class, id);
		
		System.out.println("Introduce la id del personaje al que quieras asociar un personaje");
		Integer idp = Integer.parseInt(sc.nextLine());
		Personaje personaje = em.find(Personaje.class, idp);
		videojuego.setPersonaje(personaje);
		System.out.println(videojuego);
		em.merge(videojuego);
		et.commit();
		cerrarConexion();
		return asociar;
	}

}
