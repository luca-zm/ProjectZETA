package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CollectionPointBean;
import bean.UserBean;
import controller.ControllerManageCollPoint;
import controller.ControllerShopCartCheckOut;
import controller.ControllerWishList;
import model.AbstractUser;
import model.CollectionPoint;
import model.Product;
import persistence.ProductDAO;

/**
 * Servlet implementation class ModeratorServlet
 */
@WebServlet("/ModeratorServlet")
public class ModeratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeratorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		ControllerManageCollPoint conmod = new ControllerManageCollPoint(); 
		
		
		if("add".equals(action)) {
			
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			int optime = Integer.parseInt(request.getParameter("opening"));
			int closetime = Integer.parseInt(request.getParameter("closing"));
			CollectionPointBean cb = new CollectionPointBean(0, name, address, optime, closetime);
			try {
				conmod.insert(cb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("moderator.jsp");
				
		}
		
		else if("delete".equals(action)) {
			
			int collId = Integer.parseInt(request.getParameter("collId"));
			
			CollectionPoint cp = new CollectionPoint(collId, null , 0, 0, null, 0, 0);
			try {
				conmod.delete(cp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("moderator.jsp");
		}
			
	}

}
