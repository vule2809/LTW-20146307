package VN.CDT.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/hello","/xin-chao"})
public class TEST extends HttpServlet {

	private static final long serialVersionUID = -128331050076031602L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// step1: nhan Request
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("ten");
		String lname = req.getParameter("ho");

		// step2: xu ly Request
		String fname = lname + " " + name;

		// step3: Response
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();
		out.println(lname);
		out.println(name);
		out.println(fname);
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// step1: nhan Request
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("ten");
		String lname = req.getParameter("ho");

		// step2: xu ly Request
		String fname = lname + " " + name;

		// step3: Response
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();
		out.println(lname);
		out.println(name);
		out.println(fname);

		out.close();
	}

}
