package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import modelo.entidad.Coche;

public class CocheDaoImpl implements CocheDao {

	private EntityManager em;

	private boolean abrirConexion() {
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("jpa_coches");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void addCoche(Coche coche) {
		if (!abrirConexion()) {
			System.out.println("Error de conexión");
		}
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(coche);
		et.commit();
		cerrarConexion();
	}

	@Override
	public void updateCoche(Coche coche) {
		if (!abrirConexion()) {
			System.out.println("Error de conexión");
		}
		EntityTransaction et = em.getTransaction();
		et.begin();
		coche = em.merge(coche);
		et.commit();
		cerrarConexion();
	}

	@Override
	public void deleteCoche(int id) {
		if (!abrirConexion()) {
			System.out.println("Error de conexión");
		}

		Coche cocheAux = find(id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(cocheAux);
		et.commit();
		cerrarConexion();
	}

	@SuppressWarnings("unchecked")
	public List<Coche> listar() {
		if (!abrirConexion()) {
			return null;
		}

		Query query = em.createQuery("from Coche c");
		List<Coche> listaCoches = query.getResultList();
		return listaCoches;
	}

	public Coche find(int id) {
		if (!abrirConexion()) {
			return null;
		}
		return em.find(Coche.class, id);
	}

}
