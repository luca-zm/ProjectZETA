package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ControllerShopCartCheckOut;
import controller.ControllerWishList;

/**
 * Servlet implementation class WIshlistServlet
 */
@WebServlet("/WIshlistServlet")
public class WishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");
		ControllerShopCartCheckOut controller = new ControllerShopCartCheckOut();
		if("cart".contentEquals(action)) {

			int productId = Integer.parseInt(request.getParameter("productId"));
			try {
				controller.addProduct(productId, session);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("del".contentEquals(action)) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			try {
				controller.deleteProduct(productId, session);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
