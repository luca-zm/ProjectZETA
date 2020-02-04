package webeco.src.servlet;

import java.io.IOException;





import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import laptopeco.bean.ProductBean;
import laptopeco.bean.UserBean;

import webeco.src.controller.ControllerManageProduct;
import webeco.src.controller.ControllerManageUser;
import laptopeco.logic.enums.Category;


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
        //empty
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// empty
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			ControllerManageProduct conmod = new ControllerManageProduct(); 
			ControllerManageUser cmu = new ControllerManageUser();
			String a = "admin.jsp";
			
			
			
			if("add".equals(action)) {
				
				String name=request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				String path=request.getParameter("imgpath");
				String descr=request.getParameter("descr");

				ProductBean cb = new ProductBean(0, name, price, 0, Category.UTILITY , path, descr);
				
				try {
					conmod.addProduct(cb);
				} catch (SQLException e) {
					// empty
					e.printStackTrace();
				}
				
				response.sendRedirect(a);
							
			}
			
			else if("delete".equals(action)) {
				
				int productId = Integer.parseInt(request.getParameter("productId"));
				
				ProductBean pb = new ProductBean( productId , null , 0, 0, null, null,null);
				
				try {
					conmod.deleteProduct(pb);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				response.sendRedirect(a);
				
			}
			
			else if("ban".equals(action)) {
				
				int userId = Integer.parseInt(request.getParameter("userId"));
				
				UserBean pb = new UserBean( userId , null, null, null, null, null);
				
				try {
					cmu.delete(pb);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				response.sendRedirect(a);
				
			}
				
		}
}
