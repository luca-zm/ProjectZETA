package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


		String action = request.getParameter("action");
		ControllerWishList controller = new ControllerWishList();
		if("cart".contentEquals(action)) {

			int productId = Integer.parseInt(request.getParameter("productId"));
			controller.addProduct(productId);
		}
		else if("del".contentEquals(action)) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			controller.deleteProduct(productId);
		}
	}


}
