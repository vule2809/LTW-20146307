package Services;

import java.util.List;

import DAOs.BookDAOImpl_20146307;
import DAOs.IBookDAO_20146307;
import Models.BookModel_20146307;

public class BookServiceImpl_20146307 implements IBookService_20146307 {

	IBookDAO_20146307 bkdao = new BookDAOImpl_20146307();

	@Override
	public List<BookModel_20146307> findAll() {
		return bkdao.findAll();
	}

	@Override
	public void delete(String title) {
		bkdao.delete(title);
	}

	@Override
	public void insert(BookModel_20146307 bookModel_20146422) {
		bkdao.insert(bookModel_20146422);
	}
}
