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
import controller.ControllerRegistration;
import model.Product;
import persistence.ProductDAO;

/**
 * Servlet implementation class LoginController
 */

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");
		System.out.println(action);
		System.out.println("ciao Mondo");
		
		if("login".equals(action)) {
			ControllerLogin CL = new ControllerLogin();
			String un=request.getParameter("username");
			String pw=request.getParameter("password");
			UserBean ub = new UserBean(0, null, null, un, pw, null);
			try {
				if(CL.login(ub, session))
				{
					ArrayList<Product> catalogo = ProductDAO.select();
					ArrayList<Product> catalogo_mini = ProductDAO.select();
					for(Product p: catalogo) {
						if(p.getPrice() > 100) {
							catalogo_mini.add(p);
						}
					}	
					
					System.out.println(catalogo_mini);
					session.setAttribute("catalogomini", catalogo_mini);
					session.setAttribute("catalogo", catalogo);
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
					return;
				}
				else
				{
				    // user errato
					return;
				}
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		else if("registration".contentEquals(action)) {
//			ControllerRegistration CR = new ControllerRegistration();
//			
//			<input type="text" placeholder="Name"><br><br>
//			<input type="text" placeholder="Surname"><br><br>
//			<input type="text" placeholder="Email"><br><br>
//			<input type="text" placeholder="Address with zip code"><br><br>
//			<input type="password" placeholder="Password"><br><br>
//			<input type="password" placeholder="Confirm password"><br><br>
//			
//			String name = request.getParameter("name");
//			
//            CR.register(userBean);
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			return;
//		}

	}
	

}
