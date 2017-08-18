package processing;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.SendMail;
import com.employeebean.EmployeeBean;
import com.employeebean.RolesBean;

import location.LocationDAO;
import locationbean.copy.LocationBean;
import users.RolesDAO;
import users.UserDAO;

@WebServlet("/Logic")
public class Logic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao;
	LocationDAO ldao;
	RolesDAO rdao;
	int empid;
	String column;
	SendMail sm;

	public Logic() {
		super();
		dao = new UserDAO();
		ldao = new LocationDAO();
		sm=new SendMail();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = null;
		String forward = "";
		action = request.getParameter("action");
		request.removeAttribute("emp");
		if (action.isEmpty() || action.equals(null)) {
			request.setAttribute("ldao", ldao.getAllLocations());
			// forward = "/Registration.jsp";
		} else if (action.equalsIgnoreCase("edit")) {
			forward = "/Registration.jsp";
			empid = Integer.parseInt(request.getParameter("empid"));
			EmployeeBean embs = dao.getEmpById(empid);
			// request.setAttribute("lbean", ldao.getAllLocations());
			request.setAttribute("embs", embs);

		} else if (action.equalsIgnoreCase("delete")) {
			empid = Integer.parseInt(request.getParameter("empid"));
			dao.deleteEmployee(empid);
			forward = "/listEmp.jsp";
			request.setAttribute("emp", dao.getAllEmployees());
			
		} else if (action.equalsIgnoreCase("list")) {
			forward = "/listEmp.jsp";
			request.setAttribute("emp", dao.getAllEmployees());
			

		} else if (action.equalsIgnoreCase("search")) {
			forward = "/listEmp.jsp";
			column = request.getParameter("column");
			request.setAttribute("emp", dao.getEmpByColumn(column));

		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String empid = request.getParameter("empid");
		EmployeeBean emp = new EmployeeBean();

		emp.setFname(request.getParameter("fname"));
		emp.setMname(request.getParameter("mname"));
		emp.setLname(request.getParameter("lname"));
		emp.setUsername(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));
		emp.setAddress(request.getParameter("address"));
		emp.setEmail(request.getParameter("email"));
		emp.setMobile1(request.getParameter("mobile1"));
		emp.setMobile2(request.getParameter("mobile2"));
		emp.setEnumber(request.getParameter("enumber"));

		emp.setDepartid(Integer.parseInt(request.getParameter("department")));
		emp.setLocationid(Integer.parseInt(request.getParameter("location")));

		emp.setDesignation(request.getParameter("designation"));

		if (empid > 0) {
			emp.setEmpid(empid);
			dao.updateEmployee(emp);
			// dao.addLocation(emp);
			response.sendRedirect("index.jsp");

		} else {
			String toAddress=request.getParameter("email");
			String port="587";
			String fullname=request.getParameter("fname")+" "+request.getParameter("mname")+" "+request.getParameter("lname");
			String Subject ="Welcome "+request.getParameter("fname")+" "+request.getParameter("mname")+" "+request.getParameter("lname")+" At Atidan Technologies Pvt.Ltd";
			String message="Hello "+fullname+" , Welcome to Atidan Technologies Pvt.Ltd";
			emp.setFname(request.getParameter("fname"));
			emp.setMname(request.getParameter("mname"));
			emp.setLname(request.getParameter("lname"));
			emp.setUsername(request.getParameter("username"));
			emp.setPassword(request.getParameter("password"));
			emp.setAddress(request.getParameter("address"));
			emp.setEmail(request.getParameter("email"));
			emp.setMobile1(request.getParameter("mobile1"));
			emp.setMobile2(request.getParameter("mobile2"));
			emp.setEnumber(request.getParameter("enumber"));
			emp.setDesignation(request.getParameter("designation"));
			emp.setDepartid(Integer.parseInt(request.getParameter("department")));
			emp.setLocationid(Integer.parseInt(request.getParameter("location")));
			int i = dao.addUser(emp);
//			String to = "lms.atidanmumbai@gmail.com";
//			String from = "lms.atidanmumbai@gmail.com";
			String host = "smtp.gmail.com";
			String user = "lms.atidanmumbai@gmail.com";
			String pass = "Atidan@123";
//			String sub = "Test Mail";
//			String msg = "Body here";
			try {
				sm.sendEmail(host, port, user, pass, toAddress, Subject, message);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (i > 0) {
				response.sendRedirect("empindex.jsp");
			}
		}

	}

}
