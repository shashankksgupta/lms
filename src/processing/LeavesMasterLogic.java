package processing;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.employeebean.EmployeeBean;

import leave.LeaveMasterDAO;
import leavebean.LeavesMasterBean;
import users.UserDAO;

@WebServlet("/LeavesMasterLogic")
public class LeavesMasterLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger lml = Logger.getLogger(LeavesMasterLogic.class);
	LeaveMasterDAO dao;
	int empid;
	public LeavesMasterLogic() {
        super();
       dao=new LeaveMasterDAO();
       lml.info("successfully initialized DAO class");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "LeaveMaster.jsp";
			HttpSession session=request.getSession();
			String eid=String.valueOf(session.getAttribute("empid"));
			empid=Integer.parseInt(eid);
			LeavesMasterBean leave = dao.getLeavesByEmpId(empid);
			request.setAttribute("lmbs",leave);
			lml.info("Attributes set for Viewing");
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("list")) {
			forward = "/listLeaves.jsp";
			request.setAttribute("lmb", dao.getAllLeaves()); 
			lml.info("Attributes set for listing");
		} else if (action.equalsIgnoreCase("edit")) {
			
			forward = "/LeaveMaster.jsp";
			empid = Integer.parseInt(request.getParameter("empid"));
			LeavesMasterBean lmbs = dao.getLeavesByEmpId(empid);
			request.setAttribute("lmbs",lmbs);
			lml.info("Attributes set for Editing");
		} else if (action.equalsIgnoreCase("delete")) {
			empid=Integer.parseInt(request.getParameter("empid"));
			dao.DeleteLeavesMaster(empid);
			lml.info("Delete Successfull");
//			int empid = Integer.parseInt(request.getParameter("empid"));
//			dao.deleteEmployee(empid);
//			forward = "/listEmp.jsp";
//			request.setAttribute("emp", dao.getAllEmployees());
		} else {
			
		} 
			

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String empid = request.getParameter("empid");
		LeavesMasterBean lmb = new LeavesMasterBean();
		lmb.setAnnualalloted(Integer.parseInt(request.getParameter("annualalloted")));;
		lmb.setAnnualconsumed(Integer.parseInt(request.getParameter("annualconsumed")));;
		lmb.setSickalloted(Integer.parseInt(request.getParameter("sickalloted")));;
		lmb.setSickconsumed(Integer.parseInt(request.getParameter("sickconsumed")));;
		lmb.setWfhalloted(Integer.parseInt(request.getParameter("wfhalloted")));;
		lmb.setWfhconsumed(Integer.parseInt(request.getParameter("wfhconsumed")));;
		
		if (empid >0) {

			lmb.setEmpid(empid);
			dao.updateLeavesMaster(lmb);
			// dao.addLocation(emp);
			response.sendRedirect("listlocation.jsp");
			empid=0;

		} else {
			int i = dao.addLeaveMaster(lmb);
			if (i > 0) {
				String suc = "success";
				response.getWriter().write(suc);
			}
		}
		//doGet(request, response);
		
	}

}
