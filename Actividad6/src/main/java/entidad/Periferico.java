package entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Periferico {
	
	public Periferico(double precio, String tipo, String marca) {
		this.precio = precio;
		this.tipo = tipo;
		this.marca = marca;
	}

	
	public Periferico() {
	}


	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}


	double precio;
	String tipo;
	String marca;
}
