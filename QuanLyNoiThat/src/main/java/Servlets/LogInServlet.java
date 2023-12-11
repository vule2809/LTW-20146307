package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Connection conn;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			//xá»­ lÃ½ tham sá»‘ tá»« form
			String username=request.getParameter("username");
			String password=request.getParameter("password");

			UserAccount usr=new UserAccount(username,password);
			//táº¡o Ä‘á»‘i tÆ°á»£ng user vá»›i username vÃ  password
			//thÃªm Ä‘á»‘i tÆ°á»£ng vÃ o CSDL
			
			UserAccount u=DBUntils.findUser(conn, usr.getUserName(), usr.getPassword());
			if(u != null)
			{
				UserAccount user=new UserAccount(u);
				request.setAttribute("username", "Chào bạn:  " + user.getUserName());
				request.getRequestDispatcher("/Index.jsp").forward(request, response);
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8");
				try (PrintWriter out = response.getWriter()){
					out.print("<!DOCTYPE html>");
					out.print("<html");
					out.print("<head>");
					out.print("<title>Thông báo</title>");
					out.print("/<head>");
					out.print("<body>");
					out.print("<h1>Thông tin đăng nhập không chính xác <a href=Login.jsp> Nháº­p láº¡i</a></h1>");
					out.print("</body>");
					out.print("</html>");

				}
				
			}
				
		}catch(ClassNotFoundException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE,null, ex);
			
		}catch (SQLException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE,null, ex);

		}
	}

		// TODO Auto-generated method stub
//		doGet(request, response);
	}

