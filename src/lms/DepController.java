package lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DepController")
public class DepController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DepCrud depcrud=new DepCrud();
	String forward = "";
     int deptid;


    public DepController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		List<DepModel> departmentlist = new ArrayList<DepModel>();
		if (action.equals("list")) {
			departmentlist = depcrud.getAllDepartments();
			request.setAttribute("deptlist", departmentlist);
			forward = "/DepartmentList.jsp";
		}
		else 
			if (action.equalsIgnoreCase("edit")) {
			forward = "/Department.jsp";
			deptid = Integer.parseInt(request.getParameter("did"));
			DepModel department = depcrud.getDepartmentById(deptid);
			request.setAttribute("deptlist", department);
		} else if (action.equalsIgnoreCase("delete")) {
			int deptid = Integer.parseInt(request.getParameter("did"));
			depcrud.deleteDepartment(deptid);
			forward = "/DepartmentList.jsp";
			request.setAttribute("deptlist", depcrud.getAllDepartments());
		} else {
			forward = "/Department.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepModel udep = new DepModel();
		udep.setDname(request.getParameter("dname"));
		
		
		if (deptid>0) {
			udep.setDid(deptid);
			depcrud.updateDepartment(udep);
			deptid=0;
			response.sendRedirect("IndexDepartment.jsp");
			
		}
		else {
			int i = depcrud.addDepartment(udep);
//			if (i > 0) {
//		     String suc = "success";
//		     response.getWriter().write(suc);
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('department added usccessfully');");  
			out.println("location='IndexDepartment.jsp';");
			out.println("</script>");
			
			
			}		
	
		
	//	doGet(request, response);
	}

}
