package entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Procesador {
	public Procesador(int numeroNucleos, double hz, int hilos, double precio, String marca) {
		this.numeroNucleos = numeroNucleos;
		this.hz = hz;
		this.hilos = hilos;
		this.precio = precio;
		this.marca = marca;
	}
	
	
	public Procesador() {
	}


	public int getNumeroNucleos() {
		return numeroNucleos;
	}
	public void setNumeroNucleos(int numeroNucleos) {
		this.numeroNucleos = numeroNucleos;
	}
	public double getHz() {
		return hz;
	}
	public void setHz(double hz) {
		this.hz = hz;
	}
	public int getHilos() {
		return hilos;
	}
	public void setHilos(int hilos) {
		this.hilos = hilos;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}


	int numeroNucleos;
	double hz;
	int hilos;
	double precio;
	String marca;
}
