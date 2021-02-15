package model.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dominio.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {

List<Cliente> findByNombreIgnoreCase(String nombre);
List<Cliente> findByNombreIgnoreCaseAndEmailIgnoreCase(String nombre,String email);

@Query(value="SELECT  * FROM tclientes2 WHERE Nombre LIKE ?1%  AND Provincia LIKE ?2% ;",nativeQuery=true)
List<Cliente> findByNombreEmpiezaAndProvinciaEmpieza(String Nombre,String Provincia);

List<Cliente> findByNombreStartingWithAndEmailStartingWith(String nombre,String email  );


List<Cliente> findByNombreStartingWithAndEmailContainingOrderByProvinciaAsc(String nombre,String email  );


}
