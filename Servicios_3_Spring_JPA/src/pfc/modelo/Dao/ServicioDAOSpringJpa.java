package pfc.modelo.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pfc.dominio.Cliente;
import pfc.dominio.Servicio;
import pfc.modelo.DaoInterface.ServicioDAOInterface;

@Repository
@Transactional
public class ServicioDAOSpringJpa  implements ServicioDAOInterface{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Servicio altaS(Servicio s) {
		try {em.persist(s);	} 
		catch (DataAccessException ex) {return null;}

		return s;
	}

	@Override
	public boolean bajaS(int idServicio) {
		try {Servicio s = this.consultaS(idServicio);
		em.remove(s);	} 
		catch (DataAccessException ex) {return false;}

		return true;
	}

	@Override
	public boolean modificacionS(Servicio s) {
		try {
			em.merge(s);
			}
			catch (DataAccessException ex) {return false;}
			return true;	
	}

	@Override	
	@Transactional(readOnly=true)
	public Servicio consultaS(int idServicio) {
		return em.find(Servicio.class, idServicio);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Servicio> consultaAllS() {
		Query query = em.createQuery("SELECT s FROM Servicio s");
		List<Servicio> todoslosServicios = (List<Servicio>) query.getResultList();
		return todoslosServicios;
	}

}
