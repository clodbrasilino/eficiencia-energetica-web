package br.edu.ifpi.see.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("sistema");
	private static EntityManager em = emf.createEntityManager();

	public static EntityManager getEntityManager() {
		return em;
	}

	public static EntityTransaction getTransaction() {
		return em.getTransaction();
	}
	
	public static void close() {
		em.close();
		emf.close();
	}

}
