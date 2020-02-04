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
import laptopeco.logic.model.AbstractUser;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // empty
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession(); 

		String action = request.getParameter("action");
		

		ControllerShopCartCheckOut c = new ControllerShopCartCheckOut();
		
		if("order".contentEquals(action)) {
			
			try {
			    AbstractUser user = (AbstractUser) session.getAttribute("user");
			    if(user.getCart().getTotalPrice() >= user.getGreenCoin())
			    {
					PrintWriter out = response.getWriter();
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Sorry insufficient Green Coin' ,  'Get more coins !' ,  'error' );");
					out.println("});");
					out.println("</script>");
					RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
					rd.include(request, response);
					return;
			    }
				c.buyShopCart(session);
				PrintWriter out = response.getWriter();
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Products successfully aquired !' ,  '' ,  'success' );");
				out.println("});");
				out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
				rd.include(request, response);
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
    }
}

