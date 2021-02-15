package pfc.dominio;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="tservicios")
public class Servicio implements Serializable  {
	
	private static final  long serialVersionUID = 1L;
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	private String descripcion;
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	private double importe;
	@JoinColumn(name="IdClienteC", referencedColumnName = "IdCliente")
	@ManyToOne
	private Cliente cliente;
	
	public Servicio(){}
	public Servicio( String descripcion, Calendar fecha,double importe, Cliente cliente) {
		
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.importe = importe;
		this.cliente = cliente;
	}

	
	
	
	
	
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idServicio;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		if (idServicio != other.idServicio)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Servicio [idServicio=" + this.getIdServicio() + ", descripcion=" + this.getDescripcion() + ", fecha=" + this.getFecha().getTime() + ", importe="
				+ this.getImporte() + ", cliente=" + this.getCliente().toString() + "]";
	}
	
}
