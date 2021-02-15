package dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="tclientes2")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  idCliente;
	private String provincia;
	private String email;
	private String nombre;
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "cliente",fetch=FetchType.EAGER)
	private List<Servicio>servicios;
	
	
	public Cliente() {

	}
	public Cliente(String provincia, String email, String nombre) {

		this.email=email;
		this.provincia = provincia;
		this.nombre = nombre;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + idCliente;
	return result;
}

/*Importante para los metodos ordenar comparar etc..*/
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	if (idCliente != other.idCliente)
		return false;
	return true;
}

@Override
public String toString() {
	
	return "Cliente [idCliente=" + this.getIdCliente()+ ", provincia=" + this.provincia + ", email=" + this.getEmail() + ", nombre=" + this.getNombre()
			+ "]" + " y servicios añadidos al cliente :  " +  this.getServicios().size();
	
}
}