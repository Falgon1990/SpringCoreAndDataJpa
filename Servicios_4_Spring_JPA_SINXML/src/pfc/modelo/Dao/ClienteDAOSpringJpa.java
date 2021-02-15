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
import pfc.modelo.DaoInterface.ClienteDAOInterface;


@Repository
@Transactional
public class ClienteDAOSpringJpa implements ClienteDAOInterface {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Cliente altaC(Cliente c) {
		try {em.persist(c);	} 
		catch (DataAccessException ex) {return null;}

		return c;
	}

	@Override
	public boolean bajaC(int idCliente) {
		try {
			Cliente c = this.consultaC(idCliente);
		em.remove(c);	} 
		catch (DataAccessException ex) {return false;}

		return true;
	}

	@Override
	public boolean modificacionC(Cliente c) {
		try {
		em.merge(c);
		}
		catch (DataAccessException ex) {return false;}
		return true;
	}
	
@Override	
@Transactional(readOnly=true)
	public Cliente consultaC(int idCliente) {
		return em.find(Cliente.class, idCliente);
	}
@Override
	@Transactional(readOnly=true)
	public List<Cliente> consultaAllC() {
		Query query = em.createQuery("SELECT c FROM Cliente c");
		List<Cliente> todoslosClientes = (List<Cliente>) query.getResultList();
		return todoslosClientes;
	}

}
