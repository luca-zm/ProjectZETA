package webeco.src.servlet;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webeco.src.controller.ControllerShopCartCheckOut;
import webeco.src.controller.ControllerWishList;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Product;
import laptopeco.logic.persistence.ProductDAO;

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
		String h = "homepage";
		int productId = Integer.parseInt(request.getParameter("productId"));
		if("wish".equals(action)) {
			ControllerWishList controller = new ControllerWishList();
			try {
				AbstractUser user = (AbstractUser)session.getAttribute("user");
				for(Product p: user.getWishList().getList()) {
					if(p.getId() == productId) {
						PrintWriter out = response.getWriter();
						out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
						out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){");
						out.println("swal ( 'Product already inserted in Wish List!' ,  '' ,  '' );");
						out.println("});");
						out.println("</script>");
						RequestDispatcher rd = request.getRequestDispatcher(h);
						rd.include(request, response);
						return;
					}
					
				}
				controller.addProductinWishList(productId, session);
				RequestDispatcher rd = request.getRequestDispatcher(h);
				rd.include(request, response);
			} catch (SQLException e) {
				// empty
				e.printStackTrace();
			}
			
		}
		else if("cart".equals(action)) {
			ControllerShopCartCheckOut controller = new ControllerShopCartCheckOut();
			try {
				controller.addProduct(productId, session);
				RequestDispatcher rd = request.getRequestDispatcher(h);
				rd.include(request, response);
			} catch (SQLException e) {
				// empty
				e.printStackTrace();
			}
		}
		
		else if("info".equals(action)) {
			Product p = null;
			try {
				p = ProductDAO.selectProduct(productId);
			} catch (SQLException e) {
				// empty
				e.printStackTrace();
			}
			session.setAttribute("product", p);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
	}

}
