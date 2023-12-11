package DAOs;

import java.util.List;

import Models.BookModel_20146307;

public interface IBookDAO_20146307 {

	List<BookModel_20146307> findAll();

	void delete(String title);

	void insert(BookModel_20146307 bookModel_20146422);
}
