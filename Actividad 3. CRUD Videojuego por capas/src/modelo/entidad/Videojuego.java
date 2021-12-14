package modelo.entidad;

public class Videojuego implements Comparable<Videojuego> {
	private int id;
	private String nombre;
	private String compañia;
	private double precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return id + "---" + nombre + "---" + compañia + "---" + precio;
	}

	@Override
	public int compareTo(Videojuego o) {
		// se compara por el atributo compañia
		int result = this.compañia.compareTo(o.compañia);
		return result;
	}

}
