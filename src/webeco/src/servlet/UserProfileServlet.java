package webeco.src.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptopeco.bean.ActivationCodeBean;
import webeco.src.controller.ControllerShopCartCheckOut;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
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
		ControllerShopCartCheckOut ac = new ControllerShopCartCheckOut();
		
		String action = request.getParameter("activate");

		if("activate".equals(action)) {
			
			String code=request.getParameter("code");
			ActivationCodeBean acb = new ActivationCodeBean(Integer.parseInt(code), 0);
			try {
				ac.enabledActivationCode(acb, session);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("userprofile.jsp").forward(request, response);
		}
	}

}
