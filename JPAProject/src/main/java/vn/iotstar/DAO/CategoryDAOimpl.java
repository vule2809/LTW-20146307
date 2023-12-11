package vn.iotstar.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.Config.JPAConfig;
import vn.iotstar.Entity.category;

public class CategoryDAOimpl implements ICategoryDAO {
	@Override
	public void insert(category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	@Override
	public void update(category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	@Override
	public void delete(int cateid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			category category = enma.find(category.class, cateid);
			if (category != null) {
				enma.remove(category);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	@Override
	public category findById(int categoryId) {
		EntityManager enma = JPAConfig.getEntityManager();
		category category = enma.find(category.class, categoryId);
		return category;
	}
	@Override
	public List<category> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<category> query = enma.createNamedQuery("category.findAll", category.class);
		return query.getResultList();
	}
	@Override
	public List<category> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<category> query = enma.createNamedQuery("category.findAll", category.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}
	@Override
	public List<category> findByCategoryname(String catname) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT c FROM category c WHERE c.catename like :catname";
		TypedQuery<category> query = enma.createQuery(jpql, category.class);
		query.setParameter("catename", "%" + catname + "%");
		return query.getResultList();
	}
	@Override
	public int count() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM category c";
		Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}
}
