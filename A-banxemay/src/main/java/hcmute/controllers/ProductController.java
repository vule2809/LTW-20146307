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

@WebServlet(urlPatterns = { "/user-product/findALL", "/user-product/add", "/product/update", "/product/delete" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductService proService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("findALL")) {
			findALL(req, resp);
		} else if (url.contains("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/addProduct.jsp");
			rd.forward(req, resp);
		} else if (url.contains("update")) {
			int ProductID = Integer.parseInt(req.getParameter("ProductID"));
			ProductModels model = proService.findOne(ProductID);
			req.setAttribute("pro", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/updateProduct.jsp");
			rd.forward(req, resp);
		} else if (url.contains("delete")) {
			delete(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("add")) {
			insert(req, resp);
		} else if (url.contains("update")) {
			update(req, resp);
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// thiết lập ngôn ngữ
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// nhận dữ liệu từ form
		String ProductName = req.getParameter("ProductName");
		String Brand = req.getParameter("Brand");
		int Year = Integer.parseInt(req.getParameter("Year"));
		String Color = req.getParameter("Color");
		int Price = Integer.parseInt(req.getParameter("Price"));
		String Description = req.getParameter("Description");
		int ProductID = Integer.parseInt(req.getParameter("ProductID"));

		// đưa dữ liệu vào model
		ProductModels pro = new ProductModels();
		pro.setProductID(ProductID);
		pro.setProductName(ProductName);
		pro.setBrand(Brand);
		pro.setYear(Year);
		pro.setColor(Color);
		pro.setPrice(Price);
		pro.setDescription(Description);
		// gọi phương thức insert trong services
		proService.update(pro);

		// trả về view
		resp.sendRedirect("/BanXeMay/user-product/findALL");
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// thiết lập ngôn ngữ
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// nhận dữ liệu từ form
		String ProductName = req.getParameter("ProductName");
		String Brand = req.getParameter("Brand");
		int Year = Integer.parseInt(req.getParameter("Year"));
		String Color = req.getParameter("Color");
		int Price = Integer.parseInt(req.getParameter("Price"));
		String Description = req.getParameter("Description");
		int ProductID = Integer.parseInt(req.getParameter("ProductID"));

		// đưa dữ liệu vào model
		ProductModels pro = new ProductModels();
		pro.setProductID(ProductID);
		pro.setProductName(ProductName);
		pro.setBrand(Brand);
		pro.setYear(Year);
		pro.setColor(Color);
		pro.setPrice(Price);
		pro.setDescription(Description);

		// gọi phương thức insert trong sẻvices
		proService.insert(pro);

		// trả về view
		resp.sendRedirect("/BanXeMay/user-product/findALL");

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ProductID = Integer.parseInt(req.getParameter("productID"));
		try {
			proService.delete(ProductID);
			req.setAttribute("massage", "Xoa thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "That bai ");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/user-product/findALL");
		rd.forward(req, resp);

	}

	private void findALL(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModels> listpro = proService.findALL();
		// đẩy DL ra view
		req.setAttribute("listpro", listpro);
		// view nhận DL
		RequestDispatcher rd = req.getRequestDispatcher("/views/product/listProduct.jsp");
		rd.forward(req, resp);
	}
}
