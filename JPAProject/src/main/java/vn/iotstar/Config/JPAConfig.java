package vn.iotstar.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfig {
	public static EntityManager getEntityManager() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banhang");

		return factory.createEntityManager();

		}
}
