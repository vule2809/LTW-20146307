package vn.star.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.start.Service.BookServiceImpl;
import vn.start.Service.IBookService;

@WebServlet(urlPatterns = {"/book/findALL"})
public class BookController extends HttpServlet{

	IBookService bookservice = new BookServiceImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("findALL")) {
			findALL(req, resp);
		} 
	}

}
