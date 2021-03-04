package com.clase.spring.modelo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clase.spring.dominio.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {
@Query(value="SELECT * FROM tcliente",nativeQuery=true)
List<Cliente> allClientes();
}
