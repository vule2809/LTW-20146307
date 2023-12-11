package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.ProductModels;
import hcmute.services.IProductService;
import hcmute.services.ProductServiceImpl;

@WebServlet(urlPatterns = { "/listproduct", "/findprobycate" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductService proService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("listproduct")) {

			List<ProductModels> list = proService.findALL();
			req.setAttribute("listpro", list);

			RequestDispatcher rd = req.getRequestDispatcher("/views/product/listproduct.jsp");
			rd.forward(req, resp);
		} else if (url.contains("findprobycate")) {
			int id = Integer.parseInt(req.getParameter("categoryid"));

			List<ProductModels> list1 = proService.findProductByCategory(id);
			req.setAttribute("listpro", list1);

			RequestDispatcher rd = req.getRequestDispatcher("/views/product/listproduct.jsp");
			rd.forward(req, resp);
		}
	}
}
