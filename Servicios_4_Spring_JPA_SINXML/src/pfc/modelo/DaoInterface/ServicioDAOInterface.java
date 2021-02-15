package pfc.modelo.DaoInterface;

import java.util.List;

import pfc.dominio.Servicio;

public interface ServicioDAOInterface {
	public Servicio altaS(Servicio s);
	public boolean bajaS(int idServicio);
	public boolean  modificacionS(Servicio s);
	public Servicio consultaS(int idServicio);
	public List<Servicio> consultaAllS();
}
