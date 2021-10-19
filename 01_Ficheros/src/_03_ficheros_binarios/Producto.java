package _03_ficheros_binarios;

import java.io.Serializable;

public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1646340116050987350L;
	
	private String nombre;
	private float precio;	
	private int unidadesEnExistencia;
	
	public Producto(String nombre, float precio, int unidadesEnExistencia) {
		this.nombre = nombre;
		this.precio = precio;
		this.unidadesEnExistencia = unidadesEnExistencia;
	}

	public String getNombre() {
		return nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public int getUnidadesEnExistencia() {
		return unidadesEnExistencia;
	}

	@Override
	public String toString() {
		return nombre + " Stock: " + this.unidadesEnExistencia + " Precio: " + this.precio;
	}
}