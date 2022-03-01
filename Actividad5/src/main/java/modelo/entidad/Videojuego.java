package modelo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String company;
	private Integer nota;
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_idPersonaje", referencedColumnName = "id")
	private Personaje personaje;
	
	public Videojuego() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Videojuego(Integer id, String nombre, String company, Integer nota, Personaje personaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.company = company;
		this.nota = nota;
		this.personaje = personaje;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", Company=" + this.company + ", nota=" + nota
				+ ", personaje=" + personaje + "]";
	}
	
}
