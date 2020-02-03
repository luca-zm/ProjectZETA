package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ControllerShopCartCheckOut;
import controller.ControllerWishList;
import model.AbstractUser;
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

			if("del".equals(action)) {
				int productId = Integer.parseInt(request.getParameter("productId"));
				try {
					controller.deleteProduct(productId, session);
					response.sendRedirect("cart.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			if("wish".equals(action)) {
				int productIddown = Integer.parseInt(request.getParameter("productIddown"));

				ControllerWishList cwish = new ControllerWishList();
				try {
					AbstractUser user = (AbstractUser)session.getAttribute("user");
					for(Product p: user.getWishList().getList()) {
						if(p.getId() == productIddown) {
							PrintWriter out = response.getWriter();
							out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
							out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Product already inserted in Wish List!' ,  '' ,  '' );");
							out.println("});");
							out.println("</script>");
							RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
							rd.include(request, response);
							return;
						}
						
					}
					cwish.addProductinWishList(productIddown, session);
					response.sendRedirect("cart.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if("cart".equals(action)) {
				int productIddown = Integer.parseInt(request.getParameter("productIddown"));

				try {
					controller.addProduct(productIddown, session);
					response.sendRedirect("cart.jsp");
					return;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//per schermata singolo prodotto
			if("add to cart".equals(action)) {
				int productIdup = Integer.parseInt(request.getParameter("productIdup"));

				try {
					controller.addProduct(productIdup, session);
					response.sendRedirect("product.jsp");
					return;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if("proceed to checkout".equals(action)) {
				AbstractUser user = (AbstractUser) session.getAttribute("user");
				if(user.getCart().getProductList().isEmpty()) {
					PrintWriter out = response.getWriter();
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Shop Cart is empty' ,  'Add products !' ,  'error' );");
					out.println("});");
					out.println("</script>");
					RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
					rd.include(request, response);
					return;
				}
				RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
				rd.include(request, response);
			}
	}
    
   

	
}
