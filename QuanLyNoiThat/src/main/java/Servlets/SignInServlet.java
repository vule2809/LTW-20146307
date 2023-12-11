package Servlets;
import static Servlets.DBUntils.insertUserAccount; import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"}) public class SignInServlet extends HttpServlet {
   
 @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException { Connection conn = null; //connect SQL 
try {
conn = MySQLConntUtils.getMySQLConnection(); //xử lý tham số từ form
String username=request.getParameter("username"); String gender=request.getParameter("gender"); String password=request.getParameter("password");
UserAccount usr=new UserAccount(username, gender,password); //tạo đối tượng user //thêm đối tượng vào CSDL
DBUntils.insertUserAccount(conn, usr);
request.setAttribute("username", username);
request.getRequestDispatcher("/SignIn.jsp").forward(request, response); } 
 catch (ClassNotFoundException ex) {
Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex); 
} catch (SQLException ex) {
Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex); 
}finally{
if(conn != null){ 
	try {
	conn.close();
} catch (SQLException ex) {
Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex); }
}
} }
}
