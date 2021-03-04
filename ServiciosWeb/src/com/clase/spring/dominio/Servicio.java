package com.clase.spring.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tservicio")
public class Servicio implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idServicio;
	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Nombre Servicio",unique=true)
	private String nombreServicio;
	
	@JoinColumn(name="IdCliente", referencedColumnName = "IdCliente")
	@ManyToOne
	private Cliente cliente;

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNameService() {
		return nombreServicio;
	}

	public void setNameService(String nameService) {
		this.nombreServicio = nameService;
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
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idServicio == null) ? 0 : idServicio.hashCode());
		result = prime * result + ((nombreServicio == null) ? 0 : nombreServicio.hashCode());
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
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idServicio == null) {
			if (other.idServicio != null)
				return false;
		} else if (!idServicio.equals(other.idServicio))
			return false;
		if (nombreServicio == null) {
			if (other.nombreServicio != null)
				return false;
		} else if (!nombreServicio.equals(other.nombreServicio))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", descripcion=" + descripcion + ", nameService=" + nombreServicio
				+ ", cliente=" + cliente + "]";
	}
	
	
}
