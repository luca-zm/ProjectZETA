package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import bean.AddressBean;
import bean.UserBean;
import controller.ControllerLogin;
import controller.ControllerManageCollPoint;
import controller.ControllerRegistration;
import enums.Roles;
import model.AbstractUser;
import model.CollectionPoint;
import model.Product;
import model.ShopCart;
import persistence.AddressDAO;
import persistence.CollectionPointDAO;
import persistence.ProductDAO;
import persistence.UserDAO;

/**
 * Servlet implementation class LoginController
 */

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");
		

		
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
					//ShopCart s = new ShopCart();
					AbstractUser user = (AbstractUser) session.getAttribute("user");
					if(user.getType().equals(Roles.USER)) {
						ArrayList<Product> catalogo = ProductDAO.select();
						ArrayList<Product> catalogo_mini = new ArrayList<Product>();
						ArrayList<CollectionPoint> collpoint = CollectionPointDAO.select();
						for(Product p: catalogo) {
							if(p.getPrice() > 100) {
								catalogo_mini.add(p);
								//s.addProduct(p);
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
						ArrayList<CollectionPoint> collpoint = CollectionPointDAO.select();
						session.setAttribute("collpoint", collpoint);
						request.getRequestDispatcher("moderator.jsp").forward(request, response);
						return;
					}
					
					
					if(user.getType().equals(Roles.ADMIN)) {
						ArrayList<Product> catalogo = ProductDAO.select();
						ArrayList<AbstractUser> users = UserDAO.findUsers();
						session.setAttribute("catalogo", catalogo);
						session.setAttribute("users", users);
						request.getRequestDispatcher("admin.jsp").forward(request, response);
						return;
					}
					
					
					
					
					
					
					
					

//					session.setAttribute("carrello", s.getProductList());
//					session.setAttribute("totale", s.getTotalPrice());

				}
//				else if()
//				{
//				    // user errato
//					return;
//				}
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
						System.out.println("funziona il login");

						request.getRequestDispatcher("index.jsp").forward(request, response);
						return;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		if("logout".equals(action)) {
			session.invalidate(); 
			response.sendRedirect("index.jsp");
		}

	}
	
	
//	AddressBean newadd = new AddressBean(add_r.getText(), city_r.getText(), zip_r.getText(), tel_r.getText(),
//			state_r.getText(), country_r.getText(), zone_r.getText());
//
//UserBean ub = new UserBean(0, name_r.getText(), sur_r.getText(), pass_r.getText(), mail_r.getText(), newadd);
//
//if(pass_r.getText().contentEquals(pass2_r.getText())) {
//if(cr.register(ub)) {
//JOptionPane.showMessageDialog(null, "Registration succesfully!\nPlease login now");
//a.openWin("view/login_registerPage.fxml");
//}else {
//JOptionPane.showMessageDialog(null, "User already registered, please change your email");
//}	
//}
	

}
