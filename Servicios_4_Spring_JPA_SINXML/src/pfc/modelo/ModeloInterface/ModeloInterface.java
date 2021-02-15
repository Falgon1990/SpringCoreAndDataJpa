package pfc.modelo.ModeloInterface;

import java.util.List;

import pfc.dominio.Cliente;
import pfc.dominio.Servicio;

public interface ModeloInterface {
	public Cliente altaC(Cliente c);
	public Servicio altaS(Servicio s);
	
	public boolean bajaS(int idServicio);
	public boolean bajaC(int idCliente);
	
	public boolean modificacionC(Cliente c);
	public boolean  modificacionS(Servicio s);
	
	public Cliente consultaC(int idCliente);
	public Servicio consultaS(int idServicio);
	
	public List<Servicio> consultaAllS();
    public List<Cliente> consultaAllC();
}
