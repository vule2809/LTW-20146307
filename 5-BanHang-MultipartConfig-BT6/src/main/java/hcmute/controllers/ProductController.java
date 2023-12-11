package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.models.CategoryModels;
import hcmute.models.ProductModels;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;
import hcmute.services.IProductService;
import hcmute.services.ProductServiceImpl;
import hcmute.utils.Constant;
import hcmute.utils.UploadUtils;


@WebServlet(urlPatterns = { "/listproduct", "/findprobycate","/admin-insertpro" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductService proService = new ProductServiceImpl();
	ICategoryService cateService = new CategoryServiceImpl();

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
		} else if (url.contains("admin-insertpro")) {
			List<CategoryModels> listcate = cateService.findALL();
			req.setAttribute("listcate", listcate);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/addproduct.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("admin-insertpro")) {
			insert(req,resp);
		}		
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//lay dl len tu JSP bang BeanUtils
		ProductModels model = new ProductModels();
		try {
			BeanUtils.populate(model, req.getParameterMap());
			if (req.getPart("imageLink").getSize() !=0) {
				String fileName = "" + System.currentTimeMillis();
				model.setImageLink(UploadUtils.processUpload("imageLink", req, Constant.DIR + "\\products\\", fileName));
			}
			model.setCategory(cateService.findOne(model.getcategoryID()));
			
			proService.insert(model);
			
			req.setAttribute("product", model);
			req.setAttribute("message","Add successful");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error","Add fails");
		}
		
		resp.sendRedirect(req.getContextPath()+ "/listproduct");
	}
		
}
