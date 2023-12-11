package Services;

import java.util.List;

import Models.BookModel_20146307;

public interface IBookService_20146307 {
	
	List<BookModel_20146307> findAll();

	void insert(BookModel_20146307 bookModel_20110720);

	void delete(String title);
}
