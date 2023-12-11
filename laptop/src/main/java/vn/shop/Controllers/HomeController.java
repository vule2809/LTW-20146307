package vn.shop.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.shop.BLL.IproviderBLL;
import vn.shop.BLL.providerBLLimpl;
import vn.shop.Models.provider;

@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IproviderBLL pvd = new providerBLLimpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("home")) {
			findALL(req, resp);
		}
	}

	private void findALL(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<provider> list = pvd.findALL();
		req.setAttribute("listpvd", list);
		RequestDispatcher rd = req.getRequestDispatcher("/views/common/home.jsp");
		rd.forward(req, resp);
	}

}
