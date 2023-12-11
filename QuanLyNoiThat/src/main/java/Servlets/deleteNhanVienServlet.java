package Servlets;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
* Servlet implementation class editProductServlet
*/
@MultipartConfig(
 fileSizeThreshold = 1024 * 1024 * 10,
 maxFileSize = 1024 * 1024 * 50,
 maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/deleteNhanVienServlet")
public class deleteNhanVienServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
 /**
 * @see HttpServlet#HttpServlet()
 */
 public deleteNhanVienServlet() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
// TODO Auto-generated method stub
request.setCharacterEncoding("utf-8");
 response.setCharacterEncoding("utf-8");
response.getWriter().append("Served at: ").append(request.getContextPath());
 String errorString = null;
 String id=request.getParameter("id");
NhanVien nv= new NhanVien ();
try {
Connection conn = MySQLConntUtils.getMySQLConnection();
nv = DBUntils.findNhanVien(conn, id);
} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
request.setAttribute("errorString",errorString);
request.setAttribute("nhanvien", nv);
request.getRequestDispatcher("/deleteNhanVien.jsp").forward(request, 
response);
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
// TODO Auto-generated method stub
Connection conn = null; //connect SQL
try {
request.setCharacterEncoding("utf-8");
 response.setCharacterEncoding("utf-8");
 conn = MySQLConntUtils.getMySQLConnection();
 String id=request.getParameter("id");
 String name=request.getParameter("name");
 String age=request.getParameter("age"); 
 String address=request.getParameter("address"); 
 String experience=request.getParameter("experience"); 
 
 NhanVien nv=new NhanVien(id, name, age, address, experience);
 //thêm đối tượng vào CSDL
 DBUntils.deleteNhanVien(conn, nv.getId()); 
 request.getRequestDispatcher("/NhanVienListServlet").forward(request, 
response);
} catch (ClassNotFoundException ex) {
 Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, 
ex);
 } catch (SQLException ex) {
 Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, 
ex);
 }finally{
 if(conn != null){
 try {
 conn.close();
 } catch (SQLException ex) {
 Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, 
null, ex);
 }
 }
 
 } 
//doGet(request, response);
}
}
