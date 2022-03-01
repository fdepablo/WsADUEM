package entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RAM {
	public RAM(String marca, double precio) {
		this.marca = marca;
		this.precio = precio;
	}
	
	
	public RAM() {
	}


	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	String marca;
	double precio;
}
