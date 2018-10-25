package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Carro;

public class CarroDAO {

	//Named Queries
	public Carro buscaClientePorId(int id) {
	    return JPAUtil.getEntityManager()
	        .createNamedQuery("Cliente.buscaPorId", Carro.class)
	        .setParameter("id", id)
	        .getSingleResult();
	}
	
	//Queries Dinâmicas
	public List<Carro> buscaTodosUsuarios() {
	    String jpql = "select c from Cliente c";
	    return JPAUtil.getEntityManager()
	        .createQuery(jpql, Carro.class)
	        .getResultList();
	}
	
	public void create(Carro carro) {
		
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Carro carro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	public Carro readID(long id) {
		EntityManager em=JPAUtil.getEntityManager();
		Carro consultaCliente=em.find(Carro.class, id);
		em.close();
		return consultaCliente;
	}
	
	public void delete(Carro carro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.remove(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
