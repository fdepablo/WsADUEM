package modelo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "personajes")
public class Personaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String color;
	
	@OneToOne (cascade=CascadeType.ALL)
	private Videojuego videojuego;
	
	public Personaje() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Personaje(Integer id, String nombre, String color, Videojuego videojuego) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.videojuego = videojuego;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Videojuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", color=" + color + ", videojuego=" + videojuego + "]";
	}
	
	

}
