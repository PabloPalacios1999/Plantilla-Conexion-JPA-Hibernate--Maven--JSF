package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import conexion.JPAUtil;
import model.Cliente;

public class ClienteDAO {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public boolean guardar(Cliente cliente) {
		
		boolean bandera = false;
		
		
		try {
			
			entity.getTransaction().begin();
			entity.persist(cliente);
			entity.getTransaction().commit();
			bandera = true;
			//JPAUtil.shutdown();
			entity.close();
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e);
			bandera = false;
			try {
				if(entity.getTransaction().isActive()) {
					entity.getTransaction().rollback();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Error al hacer el rollback");
				System.out.println(e1);
			}
		}
		
		
		return bandera;
		
	}
	
	public void cerrarConexion() {
		JPAUtil.shutdown();
	}
	
	public boolean editar(Cliente cliente) {
			
		boolean bandera = false;
	
		try {
			
			entity.getTransaction().begin();
			entity.merge(cliente);
			entity.getTransaction().commit();
			bandera = true;
			//JPAUtil.shutdown();
			entity.close();
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e);
			bandera = false;
			try {
				if(entity.getTransaction().isActive()) {
					entity.getTransaction().rollback();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Error al hacer el rollback");
				System.out.println(e1);
			}
		}
		
		
		return bandera;
		
	}

	public Cliente buscar(long cedula) {
		
		Cliente c = new Cliente();

		try {
			
			c = entity.find(Cliente.class, cedula);
			//JPAUtil.shutdown();
			entity.close();
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return c;
		
	}
	
	public List<Cliente> obtenerClientes() {
			
		List<Cliente> listaClientes = new ArrayList();

		try {
			
			Query q = entity.createQuery("SELECT c FROM Cliente c");
			listaClientes = q.getResultList();
			//JPAUtil.shutdown();
			entity.close();
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return listaClientes;
		
	}
	
	
	public boolean eliminar(long cedula) {
		
		boolean bandera = false;
		Cliente cliente = new Cliente();
	
		try {
			
			cliente = entity.find(Cliente.class, cedula);
			entity.getTransaction().begin();
			entity.remove(cliente);
			entity.getTransaction().commit();
			bandera = true;
			//JPAUtil.shutdown();
			entity.close();
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e);
			bandera = false;
			try {
				if(entity.getTransaction().isActive()) {
					entity.getTransaction().rollback();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Error al hacer el rollback");
				System.out.println(e1);
			}
		}
		
		
		return bandera;
		
	}
	
	
	
	
}
