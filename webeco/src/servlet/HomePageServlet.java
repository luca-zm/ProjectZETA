package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import controller.ControllerShopCartCheckOut;
import controller.ControllerWishList;
import model.AbstractUser;
import model.Product;
import persistence.ProductDAO;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");
		int productId = Integer.parseInt(request.getParameter("productId"));
		if("cart".equals(action)) {
			ControllerShopCartCheckOut controller = new ControllerShopCartCheckOut();
			try {
				AbstractUser user = (AbstractUser)session.getAttribute("user");
				for(Product p: user.getWishList().getList()) {
					if(p.getId() == productId) {
						response.sendRedirect("homepage.jsp/#");
						return;
					}
					
				}
				controller.addProduct(productId, session);
				response.sendRedirect("homepage.jsp/#");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if("wish".equals(action)) {
			ControllerWishList controller = new ControllerWishList();
			try {
				controller.addProductinWishList(productId, session);
				response.sendRedirect("homepage.jsp");
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if("info".equals(action)) {
			Product p = null;
			try {
				p = ProductDAO.selectProduct(productId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("product", p);
			request.getRequestDispatcher("product.jsp").forward(request, response);
			return;
		}
		else if("Special".equals(action)) {
			ArrayList<Product> lista = (ArrayList<Product>) session.getAttribute("catalogo");
			Product specialProduct = null;
			for(Product p: lista) {
				if(p.getName().equals("Borraccia")) {
				    specialProduct = p;
				    break;
				}
			}
			session.setAttribute("product", specialProduct);
			request.getRequestDispatcher("product.jsp").forward(request, response);
			return;
		}
	}

}
