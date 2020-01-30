package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import controller.ControllerLogin;
import model.Product;
import persistence.ProductDAO;

/**
 * Servlet implementation class LoginController
 */

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		System.out.println(un);
		System.out.println(pw);

		HttpSession session = request.getSession(); 
		
		ControllerLogin controller = new ControllerLogin();
		
		UserBean ub = new UserBean(0, null, null, un, pw, null);

		try {
			if(controller.login(ub))
			{
				System.out.println(session.getAttribute("user"));
				ArrayList<Product> catalogo = ProductDAO.select();
				session.setAttribute("catalogo", catalogo);
				
				response.sendRedirect("homepage.jsp");
				return;
			}
			else
			{
				response.sendRedirect("accessoNonConcesso.html");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
