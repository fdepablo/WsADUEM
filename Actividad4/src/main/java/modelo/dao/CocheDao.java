package modelo.dao;

import java.util.List;

import modelo.entidad.Coche;

public interface CocheDao {
	
	public void addCoche(Coche coche);
    public void updateCoche(Coche coche);
    public void deleteCoche(int id);
    public List<Coche> listar();
    public Coche find(int id);
}
