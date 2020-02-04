package webeco.src.servlet;


import java.io.IOException;

import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import webeco.src.controller.ControllerLogin;
import webeco.src.controller.ControllerManageCollPoint;
import webeco.src.controller.ControllerRegistration;
import laptopeco.logic.enums.Roles;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.CollectionPoint;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.ShopCart;
import laptopeco.logic.persistence.AddressDAO;
import laptopeco.logic.persistence.CollectionPointDAO;
import laptopeco.logic.persistence.ProductDAO;
import laptopeco.logic.persistence.UserDAO;

/**
 * Servlet implementation class LoginController
 */

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		String script = "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>";
		String scriptcloud = "<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>";
		String index = "index.jsp";
		
		ControllerManageCollPoint c = new ControllerManageCollPoint();
		URL mapUrl = null;
		try {
			
			mapUrl = c.startUrl();
			
		} catch (MalformedURLException e1) {e1.printStackTrace();} catch (SQLException e1) {e1.printStackTrace();}
		
		
		
		
		
		if("login".equals(action)) {
			ControllerLogin CL = new ControllerLogin();
			String mail=request.getParameter("username");
			String pw=request.getParameter("password");
			UserBean ub = new UserBean(0, mail, null, null, pw, null);
			
			try {
				if(CL.login(ub, session))
				{
				
					AbstractUser user = (AbstractUser) session.getAttribute("user");
					if(user.getType().equals(Roles.USER)) {
						List<Product> catalogo = ProductDAO.select();
						List<Product> catalogo_mini = new ArrayList<>();
						List<CollectionPoint> collpoint = CollectionPointDAO.select();
						for(Product p: catalogo) {
							if(p.getPrice() > 100) {
								catalogo_mini.add(p);
						
							}
						}
						session.setAttribute("mapImage", mapUrl);
						session.setAttribute("collpoint", collpoint);
						session.setAttribute("catalogomini", catalogo_mini);
						session.setAttribute("catalogo", catalogo);
						
						session.setAttribute("indirizzo", AddressDAO.findAddressById(user.getId()));
						
						request.getRequestDispatcher("homepage.jsp").forward(request, response);
						return;
						
					}
					
					if(user.getType().equals(Roles.COLLECTIONPOINTMAN)) {
						List<CollectionPoint> collpoint = CollectionPointDAO.select();
						session.setAttribute("collpoint", collpoint);
						request.getRequestDispatcher("moderator.jsp").forward(request, response);
						return;
					}
					
					
					if(user.getType().equals(Roles.ADMIN)) {
						List<Product> catalogo = ProductDAO.select();
						List<AbstractUser> users = UserDAO.findUsers();
						session.setAttribute("catalogo", catalogo);
						session.setAttribute("users", users);
						request.getRequestDispatcher("admin.jsp").forward(request, response);
						return;
					}
					

				}
				else {
					out.println(scriptcloud);
					out.println(script);
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Wrong email or password' ,  'Try again !' ,  'error' );");
					out.println("});");
					out.println("</script>");
					RequestDispatcher rd = request.getRequestDispatcher(index);
					rd.include(request, response);
				}

			} catch (SQLException | ServletException | IOException e) {
		
				e.printStackTrace();
			}
		}
		

		if("register".equals(action)) {
			ControllerRegistration cr = new ControllerRegistration();
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String pass = request.getParameter("pass");
			String confpass = request.getParameter("confpass");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String zipcode = request.getParameter("zipcode");
			String telephone = request.getParameter("telephone");
			String state = request.getParameter("state");
			String zone = request.getParameter("zone");
			
			AddressBean addr = new AddressBean(address, city, zipcode, telephone, state, zone);
			UserBean ub = new UserBean(0, email, name, surname, pass, addr);
			
			
			if(pass.contentEquals(confpass)){
				
					try {
						if(cr.register(ub)) {
							out.println(scriptcloud);
							out.println(script);
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Successfull Registration !' ,  'Login in ' ,  'success' );");
							out.println("});");
							out.println("</script>");
							RequestDispatcher rd = request.getRequestDispatcher(index);
							rd.include(request, response);
						}
						else {
							out.println(scriptcloud);
							out.println(script);
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'User already Registered' ,  'Try Again !' ,  'error' );");
							out.println("});");
							out.println("</script>");
							RequestDispatcher rd = request.getRequestDispatcher(index);
							rd.include(request, response);
						}
					} catch (SQLException | ServletException | IOException e) {
						// empty
						e.printStackTrace();
					}
			}
			else {
				out.println(scriptcloud);
				out.println(script);
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Password and confirm password are different' ,  'Try again !' ,  'error' );");
				out.println("});");
				out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher(index);
				rd.include(request, response);
			}

		}
		
		
		if("logout".equals(action)) {
			session.invalidate(); 
			response.sendRedirect(index);
		}

	}
	
	

}
