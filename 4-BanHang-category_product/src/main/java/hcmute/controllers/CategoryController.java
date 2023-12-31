package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.CategoryModels;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;

@WebServlet(urlPatterns = { "/user-category/findALL", "/user-category/add", "/category/update", "/category/delete" })
public class CategoryController extends HttpServlet {
	// gọi các phương thức trong service
	ICategoryService cateService = new CategoryServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("findALL")) {
			findALL(req, resp);
		} else if (url.contains("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/addCategory.jsp");
			rd.forward(req, resp);
		} else if (url.contains("update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModels model = cateService.findOne(id);
			req.setAttribute("cate", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/updateCategory.jsp");
			rd.forward(req, resp);
		} else if (url.contains("delete")) {
			delete(req, resp);
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			cateService.delete(id);
			req.setAttribute("massage","Xoa thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error","That bai ");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/user-category/findALL");
		rd.forward(req, resp);
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
		String cateName = req.getParameter("cateName");
		String images = req.getParameter("images");
		int id = Integer.parseInt(req.getParameter("cateID"));

		// đưa dữ liệu vào model
		CategoryModels cate = new CategoryModels();
		cate.setCateID(id);
		cate.setCateName(cateName);
		cate.setImage(images);

		// gọi phương thức insert trong sẻvices
		cateService.update(cate);

		// trả về view
		resp.sendRedirect("/BanHang/user-category/findALL");

	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// thiết lập ngôn ngữ
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// nhận dữ liệu từ form
		String cateName = req.getParameter("cateName");
		String images = req.getParameter("images");

		// đưa dữ liệu vào model
		CategoryModels cate = new CategoryModels();
		cate.setCateName(cateName);
		cate.setImage(images);

		// gọi phương thức insert trong sẻvices
		cateService.insert(cate);

		// trả về view
		resp.sendRedirect("/BanHang/user-category/findALL");

	}

	private void findALL(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModels> listcate = cateService.findALL();

		// đẩy DL ra view
		req.setAttribute("list", listcate);

		// view nhận DL
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listCategory.jsp");
		rd.forward(req, resp);
	}

}
