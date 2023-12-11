package vn.star.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import vn.star.Config.JPAConfig;
import vn.star.Entity.Books;

public class BookDaoImpl implements IBookDao{

	@Override
	public void insert(Books book) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(book);
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
	public void update(Books book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int cateid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Books findById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
