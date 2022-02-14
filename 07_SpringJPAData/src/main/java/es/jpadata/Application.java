package es.jpadata;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.jpadata.modelo.entidad.Pelicula;
import es.jpadata.modelo.persistencia.DaoPelicula;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private Pelicula pelicula;
	
	@Autowired
	private DaoPelicula dp;
		
	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Application.class, args);
		
		//pelicula = context.getBean("pelicula",Pelicula.class);
		System.out.println("Main acaba");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		pelicula.setTitulo("Lo que el viento se llevo");
		pelicula.setDirector("Popeye");
		pelicula.setFechaAlta(new Date());
		pelicula.setGenero("Scifi");
		pelicula.setYear(1939);
		
		List<Pelicula> listaPeliculas = dp.findAll();
		
		System.out.println("Listado las peliculas");
		listaPeliculas.forEach(v -> System.out.println(v));
		
		System.out.println("Dando de alta la pelicula");
		dp.save(pelicula);
		
		listaPeliculas = dp.findAll();
		System.out.println("Listado las peliculas");
		listaPeliculas.forEach(v -> System.out.println(v));
		
		System.out.println("Buscar por id");
		//En spring el metodo findById, trabaja con optionals
		//Que es un concepto el cual envuelve al objeto de verda
		//y sirve para evitar null pointer
		Optional<Pelicula> optional = dp.findById(2);
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}
		
		System.out.println(optional.orElse(new Pelicula()));
		
		System.out.println("Busqueda por director");
		listaPeliculas = dp.findByDirector("popeye");
		listaPeliculas.forEach(v -> System.out.println(v));
		
		System.out.println("Busqueda por viento");
		listaPeliculas = dp.findByTitulo("viento");
		listaPeliculas.forEach(v -> System.out.println(v));
		
		System.out.println("Busqueda que contenga viento");
		listaPeliculas = dp.findByTituloContaining("viento");
		listaPeliculas.forEach(v -> System.out.println(v));
		
	}

}
