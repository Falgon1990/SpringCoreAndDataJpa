package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name="tcliente")
public class Cliente implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idCliente;
@Column(name="Usuario",unique=true)
private String usuario;
@Column(name="Password")
private String password;
@Column(name="Email")
private String email;
@Column(name="Rol")
private String rol;
@Column(name="Habilitado")
private boolean habilitado;

@OneToMany(mappedBy = "cliente")
private List<Servicio>servicios;


public Cliente() {}


public Integer getIdCliente() {
	return idCliente;
}

public void setIdCliente(Integer idCliente) {
	this.idCliente = idCliente;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getRol() {
	return rol;
}

public void setRol(String rol) {
	this.rol = rol;
}

public boolean isHabilitado() {
	return habilitado;
}

public void setHabilitado(boolean habilitado) {
	this.habilitado = habilitado;
}

public List<Servicio> getServicios() {
	return servicios;
}

public void setServicios(List<Servicio> servicios) {
	this.servicios = servicios;
}


@Override
public String toString() {
	final int maxLen = 10;
	return "Cliente [idCliente=" + idCliente + ", usuario=" + usuario + ", password=" + password + ", email=" + email
			+ ", rol=" + rol + ", habilitado=" + habilitado ;
}	




}
