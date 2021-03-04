package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Servicio;

public interface ServicioRepositorio extends JpaRepository<Servicio,Integer> {

}
