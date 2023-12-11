package vn.star.Dao;

import java.util.List;

import vn.star.Entity.Books;

public interface IBookDao {
	void insert(Books book);

	void update(Books book);

	void delete(int bookId) throws Exception;

	Books findById(int bookId);

	List<Books> findAll();

	List<Books> findAll(int page, int pagesize);

	int count();
}