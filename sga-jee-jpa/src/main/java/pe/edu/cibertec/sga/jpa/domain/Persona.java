package pe.edu.cibertec.sga.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// En la consulta se esta utilizando el lenguaje de consulta jpql
@Entity

// Las consultas estan separadas por comas.
@NamedQueries({ @NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p ORDER BY p.idPersona") })

//solo es necesario especificar "name" si tienen nombres diferentes.
@Table(name="persona")				

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// solo es necesario especificar "name" en @Column si tienen nombres diferentes.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
	@Column(name="id_persona")		
	private int idPersona;
	
	@Column(nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido_paterno", nullable=false, length=45)
	private String apePaterno;
	
	@Column(name="apellido_materno", length=45)
	private String apeMaterno;
	
	@Column(nullable=false, length=45)
	private String email;
	
	@Column(nullable=false, length=45)
	private String telefono;
	
	public Persona(){}
	
	public Persona(int idPersona, String nombre, String apePaterno,
			String apeMaterno, String email, String telefono) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;		
		this.email = email;
		this.telefono = telefono;
	}

	public Persona(String nombre, String apePaterno,
			String apeMaterno, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;		
		this.email = email;
		this.telefono = telefono;
	}
	
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
				+ ", apeMaterno=" + apeMaterno + ", apePaterno=" + apePaterno
				+ ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
}
