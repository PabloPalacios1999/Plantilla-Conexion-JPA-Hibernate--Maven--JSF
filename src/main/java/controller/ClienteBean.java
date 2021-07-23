package controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ClienteDAO;
import model.Cliente;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {
	
	public List<Cliente> obtenerClientes(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		return clienteDAO.obtenerClientes();
	}
	
	public String editar(long cedula) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(cedula);
		System.out.println(c);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/editar.xhtml";
	}
	
	public String cerrar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cerrarConexion();
		return "/faces/inicio.xhtml";
	}
	
	public String guardar(Cliente cliente) {
		Date date = new Date();
		cliente.setFechaRegistro(new java.sql.Date(date.getTime()));
		cliente.setFechaActualizacion(new java.sql.Date(date.getTime()));
		System.out.println(date.getTime());
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.guardar(cliente);
		
		System.out.println("Guardado...");
		return "/faces/index.xhtml";
	}
	
	
	public String actualizar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		if(clienteDAO.editar(cliente)) {
			System.out.println("cliente editado");
		}else {
			System.out.println("Falla en la edicion");
		}
		return "/faces/index.xhtml";
	}
	
	public String eliminar(long cedula) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(cedula);
		System.out.println("Cliente eliminado");
		
		return "/faces/index.xhtml";
	}
	
	public String nuevo() {
		Cliente c = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/registrar.xhtml";
	}

}
