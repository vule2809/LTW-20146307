package Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.BookModel_20146307;
import Services.BookServiceImpl_20146307;
import Services.IBookService_20146307;

@WebServlet(urlPatterns = { "/user/home", "/admin/books", "/admin/add", "/admin/update", "/admin/delete"})
public class HomeController_20146307 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IBookService_20146307 bookService = new BookServiceImpl_20146307();
//	IAuthorService_20146422 authorService = new AuthorServiceImpl_20146422();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("home")) {
			List<BookModel_20146307> list = bookService.findAll();
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/views/book/listbook.jsp");
			rd.forward(req, resp);
		} else if (url.contains("books")) {
			List<BookModel_20146307> list = bookService.findAll();
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/views/books/listbook.jsp");
			rd.forward(req, resp);
		} else if (url.contains("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/books/addbook.jsp");
			rd.forward(req, resp);
		}
//		else if (url.contains("update")) {
//			int id = Integer.parseInt(req.getParameter("id"));
//			AuthorModel_20146422 model = authorService.findOne(id);
//			req.setAttribute("author", model);
//			RequestDispatcher rd = req.getRequestDispatcher("/views/author/updateauthor.jsp");
//			rd.forward(req, resp);
//		}
		else if(url.contains("delete")) {
			delete(req,resp);
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("add")) {
			insert(req, resp);
		}
//		else if (url.contains("update")) 
//		{ 
//			update(req, resp); 
//		}
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		
		try {
			bookService.delete(title);
			req.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Thất bại");
		}
		RequestDispatcher rd = req.getRequestDispatcher("books");
		rd.forward(req, resp);
	}

//	private void update(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
//		// Thiết lập ngôn ngữ
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//
//		// Nhận dữ liệu từ form
//		String name = req.getParameter("author_name");
//		String dobString = req.getParameter("date_of_birth");
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		
//		int id = Integer.parseInt(req.getParameter("author_id"));
//
//		
//		try {
//			Date dob = dateFormat.parse(dobString);
//
//			AuthorModel_20146422 add = new AuthorModel_20146422();
//			add.setAuthor_id(id);
//			add.setAuthor_name(name);
//			add.setDate_of_birth(dob);
//
//			// Gọi phương thức insert trong service
//			authorService.update(add);
//
//			// Chuyển trang
//			resp.sendRedirect("author");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		// Thiết lập ngôn ngữ
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// Nhận dữ liệu từ form
		String isbn = req.getParameter("isbn");
		int isbn1 = Integer.parseInt(isbn);
		String title = req.getParameter("title");
		String publisher = req.getParameter("publisher");
		String price = req.getParameter("price");
		BigDecimal p1 = new BigDecimal(price);
		String description = req.getParameter("description");
		String dobString = req.getParameter("publishDate");
		String image = req.getParameter("coverImage");
		String quantity = req.getParameter("quantity");
		int q1 = Integer.parseInt(quantity);

	

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date dob = dateFormat.parse(dobString);

			BookModel_20146307 add = new BookModel_20146307();
			add.setIsbn(isbn1);
			add.setTitle(title);
			add.setPublisher(publisher);
			add.setPrice(p1);
			add.setDescription(description);
			add.setPublishDate(dob);
			add.setCoverImage(image);
			add.setQuantity(q1);

			// Gọi phương thức insert trong service
			bookService.insert(add);

			// Chuyển trang
			resp.sendRedirect("books");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
