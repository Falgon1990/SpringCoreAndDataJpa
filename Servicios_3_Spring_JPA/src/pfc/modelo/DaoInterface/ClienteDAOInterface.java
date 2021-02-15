package pfc.modelo.DaoInterface;

import java.util.List;

import pfc.dominio.Cliente;

public interface ClienteDAOInterface {
	
	public Cliente altaC(Cliente c);
	public boolean bajaC(int idCliente);
	public boolean modificacionC(Cliente c);
	public Cliente consultaC(int idCliente);
	public List<Cliente> consultaAllC();
}
