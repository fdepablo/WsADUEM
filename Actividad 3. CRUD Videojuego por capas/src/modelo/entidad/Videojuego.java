package modelo.entidad;

public class Videojuego implements Comparable<Videojuego> {
	private int id;
	private String nombre;
	private String compa�ia;
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

	public String getCompa�ia() {
		return compa�ia;
	}

	public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return id + "---" + nombre + "---" + compa�ia + "---" + precio;
	}

	@Override
	public int compareTo(Videojuego o) {
		// se compara por el atributo compa�ia
		int result = this.compa�ia.compareTo(o.compa�ia);
		return result;
	}

}
