package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Cliente;
import beans.Direccion;
import beans.Familia;
import beans.Persona;

public class _04_Herencia {
	public static void main(String[] args) {
		var variable = 1;
		variable = 8;
		var variable2 = new Persona();
		
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Cliente.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;//Dejamos de ejecutar el metodo main
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Cliente c = new Cliente();
			c.setIdPersona(1);
			c.setNombre("Stark");
			c.setCodigo("234");
			c.setApellido("Garcia");
			c.setDireccion(new Direccion());
			m.marshal(c, System.out);
		}catch (Exception e) {
			System.out.println("Error");
		}
	}	
}
