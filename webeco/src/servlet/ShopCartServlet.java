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

import controller.ControllerShopCartCheckOut;
import model.Product;
import persistence.ProductDAO;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession(); 

			String action = request.getParameter("action");
			ControllerShopCartCheckOut controller = new ControllerShopCartCheckOut();
			if("del".contentEquals(action)) {
				int productId = Integer.parseInt(request.getParameter("productId"));
				try {
					controller.deleteProduct(productId, session);
					response.sendRedirect("cart.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
    
    /**protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession(); 
    	
		String action = request.getParameter("action");
		
		ArrayList<Product> catalogo = null;
		try {
			catalogo = ProductDAO.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("cart".contentEquals(action)) {

		session.setAttribute("catalogo", catalogo);
		}
		/**else if("del".contentEquals(action)) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			controller.deleteProduct(productId);
		}**/


	
}
