package model.data;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dominio.Cliente;
import dominio.Servicio;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio,Integer> {
List<Servicio> findAllByFechaBetweenOrderByDescripcionDesc(GregorianCalendar fecha1,GregorianCalendar fecha2);

List<Servicio> findByFechaAfter(GregorianCalendar fecha1);

List<Servicio> findByImporteGreaterThan(Double price);

List<Servicio> findByImporteLessThanOrFechaBefore(Double precio,GregorianCalendar fecha);


}
