package hcmute.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.CategoryModels;

@WebServlet(urlPatterns = { "/listcate" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		findALL(req,resp);

	}

	private void findALL(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CategoryModels> listcate = new ArrayList<CategoryModels>();
		String sql = "Select * from category";
		
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection(); //kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); //ném câu lệnh sql bằng phát biểu preparestatement
			ResultSet rs = ps.executeQuery(); //thực thi câu Quẻy và trả về Réultset
			while (rs.next()) { //duyệt từng dòng trong Resultset, trả về danh sách đối tượng
				CategoryModels category = new CategoryModels();
				category.setCateID(rs.getInt("categoryID"));
				category.setCateName(rs.getString("categoryname"));
				category.setImage(rs.getString("icon"));
				listcate.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//đẩy DL ra view
		req.setAttribute("list", listcate);
		
		//view nhận DL
		RequestDispatcher rd = req.getRequestDispatcher("/views/listCategory.jsp");
		rd.forward(req, resp);
				
	}

}
