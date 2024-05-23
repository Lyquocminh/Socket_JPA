package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("ontapck");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public EntityManager getEnManager() {
		return entityManager;
	}

	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
