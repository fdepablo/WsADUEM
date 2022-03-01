package modelo;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidad.Periferico;
import entidad.Procesador;
import entidad.RAM;
import entidad.TarjetaGrafica;
import entidad.Ordenador;

public class Pruebas {
	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Ordenador.class);
			Marshaller marsh;
			marsh = contexto.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//Creación del objeto (igual que en el ejercicio original)
			Procesador miProcesador = new Procesador(4,4.1,2,150,"Intel");
			RAM miVram = new RAM("Asus",30);
			TarjetaGrafica miTarjeta = new TarjetaGrafica("Asus", 325.2 , "GTX 1070",miVram);
			RAM miRam1 = new RAM("Corsair",40);
			RAM miRam2 = new RAM("Corsair",40);
			Periferico SamsungLED = new Periferico(140.99, "monitor", "Samsung");
			Periferico RazerEpic = new Periferico(90, "teclado", "Razer");
			Periferico webcam = new Periferico(69.50, "camara web", "Mercadona");
			ArrayList<TarjetaGrafica> misTarjetas = new ArrayList<TarjetaGrafica>();
			misTarjetas.add(miTarjeta);
			ArrayList<RAM> misRAM = new ArrayList<RAM>();
			misRAM.add(miRam1);
			misRAM.add(miRam2);
			ArrayList<Periferico> misPerifericos = new ArrayList<Periferico>();
			misPerifericos.add(webcam);
			misPerifericos.add(RazerEpic);
			misPerifericos.add(SamsungLED);
			Ordenador miOrdenador = new Ordenador("Dell",miProcesador,misTarjetas,misRAM,misPerifericos);
			
			marsh.marshal(miOrdenador, System.out);
			marsh.marshal(miOrdenador, new File("Ordenador.txt"));
			
			//El ordenador queda serializado, se imprime por consola y se pasa a un documento txt.
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
