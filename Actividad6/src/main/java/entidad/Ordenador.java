package entidad;
/***
 * @author Diego Montenegro Calvo
 * 
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ordenador {
	
	private String marca;
	private Date year;
	private double precio;
	private Procesador procesador;
	private ArrayList<TarjetaGrafica> listaTarjetaGrafica;
	private ArrayList<RAM> listaRAM;
	private ArrayList<Periferico> listaPerifericos;
	
	public Ordenador(String marca, Procesador procesador, ArrayList<TarjetaGrafica> listaTarjetaGrafica,
			ArrayList<RAM> listaRAM, ArrayList<Periferico> listaPerifericos) {
		this.marca = marca;
		this.procesador = procesador;
		this.listaTarjetaGrafica = listaTarjetaGrafica;
		this.listaRAM = listaRAM;
		this.listaPerifericos = listaPerifericos;
	}
	
	public Ordenador() {
		
	}
	

	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public Date getYear() {
		return year;
	}



	public void setYear(Date year) {
		this.year = year;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public Procesador getProcesador() {
		return procesador;
	}



	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}


    @XmlElement(name = "tarjeta_grafica")
	@XmlElementWrapper(name = "tarjetas_graficas")
	public ArrayList<TarjetaGrafica> getListaTarjetaGrafica() {
		return listaTarjetaGrafica;
	}



	public void setListaTarjetaGrafica(ArrayList<TarjetaGrafica> listaTarjetaGrafica) {
		this.listaTarjetaGrafica = listaTarjetaGrafica;
	}


	@XmlElement(name = "ram")
	@XmlElementWrapper(name = "lista_ram")
	public ArrayList<RAM> getListaRAM() {
		return listaRAM;
	}



	public void setListaRAM(ArrayList<RAM> listaRAM) {
		this.listaRAM = listaRAM;
	}


	@XmlElement(name = "periferico")
	@XmlElementWrapper(name = "perifericos")
	public ArrayList<Periferico> getListaPerifericos() {
		return listaPerifericos;
	}



	public void setListaPerifericos(ArrayList<Periferico> listaPerifericos) {
		this.listaPerifericos = listaPerifericos;
	}
}