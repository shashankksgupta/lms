package processing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeebean.EmployeeBean;
import com.employeebean.RolesBean;

import users.RolesDAO;
import users.UserDAO;

@WebServlet("/RolesLogic")
public class RolesLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao;
	RolesDAO rdao;
	int empid;
	public RolesLogic() {
		super();
		dao = new UserDAO();
		rdao = new RolesDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("list")) {
			forward = "/listRoles.jsp";
			request.setAttribute("rob", rdao.getAllRoles());	
			
		} else if (action.equalsIgnoreCase("edit")) {
			empid=Integer.parseInt(request.getParameter("empid"));
			forward = "/RolesMaster.jsp";
			request.setAttribute("robs", rdao.getRoleById(empid));	
//			request.setAttribute("emp", dao.getAllEmployees());
			
			
		} else if (action.equalsIgnoreCase("delete")){
			empid=Integer.parseInt(request.getParameter("empid"));
			rdao.deleteRole(empid);
			forward = "/rolesRedirect.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RolesBean rob = new RolesBean();
		rob.setIsadmin(request.getParameter("isadmin"));
		rob.setIsapprover(request.getParameter("isapprover"));
		if(empid>0) {		
			rob.setEmpid(empid);
			rdao.updateRole(rob);
			empid=0;
			
		}
		//response.sendRedirect("rolesRedirect.jsp");
		
	}

}
