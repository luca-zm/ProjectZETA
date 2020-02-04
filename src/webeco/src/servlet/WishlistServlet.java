package webeco.src.servlet;

import java.io.IOException;


import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webeco.src.controller.ControllerShopCartCheckOut;
import webeco.src.controller.ControllerWishList;
import laptopeco.logic.model.AbstractUser;

/**
 * Servlet implementation class WIshlistServlet
 */
@WebServlet("/WishlistServlet")
public class WishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");


		int productId = Integer.parseInt(request.getParameter("productId"));

		if("cart".equals(action)) {
			try {
				ControllerShopCartCheckOut controller = new ControllerShopCartCheckOut();
				controller.addProduct(productId, session);
				response.sendRedirect("wishlist.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if("del".contentEquals(action)) {
			try {
				ControllerWishList controller2 = new ControllerWishList();
				controller2.deleteProductfromWishList(productId, session);
				AbstractUser user = (AbstractUser) session.getAttribute("user");
				System.out.println(user.getWishList().getList());
				response.sendRedirect("wishlist.jsp");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
