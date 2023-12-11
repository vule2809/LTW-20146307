package exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.CategoryModels;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;

@WebServlet(urlPatterns = {"/addcate"})
public class InsertCategoryController extends HttpServlet{
	
	ICategoryService cateService = new CategoryServiceImpl();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/addCategory.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập ngôn ngữ 
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
				
		//nhận dữ liệu từ form
		String cateName = req.getParameter("cateName");
		String images = req.getParameter("images");
		
		// đưa dữ liệu vào model
		CategoryModels cate = new CategoryModels();
		cate.setCateName(cateName);
		cate.setImage(images);
		
		//gọi phương thức insert trong sẻvices
		cateService.insert(cate);
		
		//trả về view
		//RequestDispatcher rd = req.getRequestDispatcher("/listcate");
		//rd.forward(req, resp);
		resp.sendRedirect("/BanHang/category/findALL");
				
	}
}
