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
@WebServlet("/editProductServlet")
public class editProductServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
 /**
 * @see HttpServlet#HttpServlet()
 */
 public editProductServlet() {
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
Product product= new Product();
try {
Connection conn = MySQLConntUtils.getMySQLConnection();
product = DBUntils.findProduct(conn, id);
} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
request.setAttribute("errorString",errorString);
request.setAttribute("product", product);
request.getRequestDispatcher("/editProduct.jsp").forward(request, 
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
 String type=request.getParameter("type"); 
 int price=Integer.parseInt(request.getParameter("price"));
 String image=""; 
 Part part= request.getPart("image");
 String fileName=extractFileName(part);
 fileName=new File(fileName).getName();
 part.write("D:\\Eclipse-workspace\\QLBH\\src\\main\\webapp\\WebContent\\Image\\"+fileName);
 image="Images/"+fileName;
 Product pro=new Product(id, name, type, price, image); //tạo đối tượng product
 //thêm đối tượng vào CSDL
 DBUntils.updateProduct(conn, pro); 
 request.getRequestDispatcher("/ProductListServlet").forward(request, 
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
private String extractFileName(Part part) {
 String contentDisp = part.getHeader("content-disposition");
 String[] items = contentDisp.split(";");
 for (String s : items) {
 if (s.trim().startsWith("filename")) {
 return s.substring(s.indexOf("=") + 2, s.length() - 1);
 }
 }
 return "";
 }
}
