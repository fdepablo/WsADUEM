package entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TarjetaGrafica {
	public TarjetaGrafica(String marca, double precio, String modelo, RAM vram) {
		this.marca = marca;
		this.precio = precio;
		this.modelo = modelo;
		this.vram = vram;
	}
	
	public TarjetaGrafica() {
		
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public RAM getVram() {
		return vram;
	}

	public void setVram(RAM vram) {
		this.vram = vram;
	}


	String marca;
	double precio;
	String modelo;
	RAM vram;
}
