package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AddressBean;
import bean.CollectionPointBean;
import bean.ProductBean;
import bean.UserBean;
import controller.ControllerManageCollPoint;
import controller.ControllerManageProduct;
import controller.ControllerManageUser;
import enums.Category;
import model.CollectionPoint;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
			ControllerManageProduct conmod = new ControllerManageProduct(); 
			ControllerManageUser cmu = new ControllerManageUser();
			
			
			
			if("add".equals(action)) {
				
				String name=request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				String path=request.getParameter("imgpath");
				String descr=request.getParameter("descr");

				ProductBean cb = new ProductBean(0, name, price, 0, Category.utility , path, descr, true);
				
				try {
					conmod.addProduct(cb);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect("admin.jsp");
							
			}
			
			else if("delete".equals(action)) {
				
				int productId = Integer.parseInt(request.getParameter("productId"));
				
				ProductBean pb = new ProductBean( productId , null , 0, 0, null, null,null, true);
				
				try {
					conmod.deleteProduct(pb);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect("admin.jsp");
				
			}
			
			else if("ban".equals(action)) {
				
				int userId = Integer.parseInt(request.getParameter("userId"));
				
				UserBean pb = new UserBean( userId , null, null, null, null, null);
				
				try {
					cmu.delete(pb);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				response.sendRedirect("admin.jsp");
				
			}
				
		}
}
