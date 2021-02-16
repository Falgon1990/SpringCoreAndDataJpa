package model.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dominio.Cliente;
/**
 *Podemos encontrar que ClienteRepositorio hereda de
 * JpaReppository en vez de CrudReposiotory en vez de este ultimo 
 * esto se debe basicamente CrudRepository tiene algunos metodos de busqueda, pero 
 * por ejemplo paginacion no tiene , paginacion permite mayor velocidad a que extrae n Elementos de la 
 * bbdd.Se comporta igual que CrudRepository<Clase a la que hace referencia,el tipo de valor de la clave primaria>
 */

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {
  /**
   *Podemos realizar metodos de consulta personalizada , de dos maneras ya sea con @Query y indicando la consulta dentro de value
   *para que no tome por defecto el lenguaje de consulta como jpql,debemos indicar que la consulta va a ser de forma true, con el 
   *atributo nativeQuery=true;
   *Pero spring nos ofrece crear consultas personalizadas siguiendo su sintaxis como norma siguiendo la siguiene forma:
   *findBy/findAllBy/count entre alguno mas  + nombre de propiedad del dominio + aqui podemos utilizar algunos  como (StartingWith,Containing,EndingWith,IgnoreCase...) entre otros 
   *+And/Or+nombre de otra propiedad del dominio + con lo mencionado anteriormente como  StartingWith ... + si queremos ordenarlo por alguna propiedad  + Asc/Desc;
   *  Aqui podemos visualizar algunos ejemplos en el ServicioRepository podemos visualizar otros ejemplos .
   *
   */

List<Cliente> findByNombreIgnoreCase(String nombre);
List<Cliente> findByNombreIgnoreCaseAndEmailIgnoreCase(String nombre,String email);

@Query(value="SELECT  * FROM tclientes2 WHERE Nombre LIKE ?1%  AND Provincia LIKE ?2% ;",nativeQuery=true)
List<Cliente> findByNombreEmpiezaAndProvinciaEmpieza(String Nombre,String Provincia);

List<Cliente> findByNombreStartingWithAndEmailStartingWith(String nombre,String email  );


List<Cliente> findByNombreStartingWithAndEmailContainingOrderByProvinciaAsc(String nombre,String email  );


}
