package vn.ute.controllers.api;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.ute.util.Constant;
import vn.ute.util.HttpUtil;
import vn.ute.util.UploadUtils;
import vn.ute.Entity.Category;
import vn.ute.Service.ICategoryService;

@MultipartConfig
@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPI extends HttpServlet {

	private ICategoryService categoryService;
	private static final long serialVersionUID = -915988021506484384L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		mapper.writeValue(response.getOutputStream(),categoryService.findAll());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// khỏi tạo đối tượng entity
		Category category = new Category();
		// sử dụng BeanUtils để tự lấy các name Field trên form
		// tên field phải trùng với entity
		try {
			BeanUtils.populate(category, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		// xử lý hình ảnh
		String fileName = "" + System.currentTimeMillis();
		category.setIcon(UploadUtils.processUpload("icon", request, Constant.DIR + "\\category\\", fileName));
		categoryService.insert(category);
		mapper.writeValue(response.getOutputStream(), category);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// lấy dữ liệu từ jsp bằng BeanUtils
		Category category = new Category();
		try {
			BeanUtils.populate(category, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		// khởi tạo DAO
		Category oldcate = categoryService.findById(category.getCategoryID());
		// xử lý hình ảnh
		if (request.getPart("icon").getSize() == 0) {
			category.setIcon(oldcate.getIcon());
		} else {
			if (oldcate.getIcon() != null) {
				// XOA ANH CU DI
				String fileName = oldcate.getIcon();
				File file = new File(Constant.DIR + "\\category\\" + fileName);
				if (file.delete()) {
					System.out.println("Đã xóa thành công");
				} else {
					System.out.println(Constant.DIR + "\\category\\" + fileName);
				}
			}
			String fileName = "" + System.currentTimeMillis();
			category.setIcon(UploadUtils.processUpload("icon", request, Constant.DIR + "\\category\\", fileName));
		}
		categoryService.update(category);
		mapper.writeValue(response.getOutputStream(), category);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Category cateModel = HttpUtil.of(request.getReader()).toModel(Category.class);
		try {
			categoryService.delete(cateModel.getCategoryID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapper.writeValue(response.getOutputStream(), "{Đã xóa thành công}");
	}

}
