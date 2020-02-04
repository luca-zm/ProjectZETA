package webeco.src.servlet;

import java.io.IOException;

import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laptopeco.bean.CollectionPointBean;
import webeco.src.controller.ControllerManageCollPoint;
import laptopeco.logic.model.CollectionPoint;

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
    }

	/**
	 *   @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				e.printStackTrace();
			}
			response.sendRedirect("moderator.jsp");
		}
			
	}

}
