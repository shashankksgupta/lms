package lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.SendMail;
import com.employeebean.EmployeeBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import users.UserDAO;

import org.apache.log4j.Logger;
@WebServlet("/AppController")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	//Gson gson = new GsonBuilder().setPrettyPrinting().create();
	//String jsonArray = gson.toJson(JSONROOT);
	final static Logger testlog = Logger.getLogger(AppController.class);

	CrudDao cruddao = new CrudDao();
	UserDAO udao;
	SendMail sm;
	int appid=0;
	int testid=0;
	ApproverCrud adao;
	

	//private GenericServlet console;

	String forward = "";

	public AppController() {
	super();
	udao=new UserDAO();
	sm= new SendMail();
		adao=new ApproverCrud();
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		// if ( action != null)
		// {
		List<AppModel> applicationlist = new ArrayList<AppModel>();
		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// response.setContentType("application/json");
		if (action.equals("list")) {
			// try {
			// Fetch Data from applicationmaster Table
			applicationlist = cruddao.getAllApplications();
			request.setAttribute("applist", applicationlist);
			forward = "/ListApplication.jsp";
		}
		else if (action.equalsIgnoreCase("edit")) {
			forward = "/Application.jsp";
			appid = Integer.parseInt(request.getParameter("appid"));
			AppModel appltns = cruddao.getApplicationById(appid);
			request.setAttribute("app", appltns);
		} else if (action.equalsIgnoreCase("delete")) {
			int aid = Integer.parseInt(request.getParameter("appid"));
			cruddao.deleteApplication(aid);
			forward = "/ListApplication.jsp";
			request.setAttribute("applist", cruddao.getAllApplications());
		} 
		else if(action.equals("nothing")){
			List<ApproverModel> approverlist = new ArrayList<ApproverModel>();
			HttpSession session=request.getSession();
			String name=String.valueOf(session.getAttribute("empid"));
			
			testid=Integer.parseInt(name);
			forward = "/Application.jsp";
			EmployeeBean embs = udao.getEmpById(testid);			
			session.setAttribute("session", embs);
			approverlist=adao.getApproverByColumn(testid);
			session.setAttribute("appr", approverlist);		
			//request.setAttribute("emp", embs);
		}else {
			forward = "/Application.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		// Return in the format required by jTable plugin
		// JSONROOT.put("Result","OK");
		// JSONROOT.put("Records", applicationlist);
		// Convert Java Object to Json
		// String jsonArray = gson.toJson(JSONROOT);
		// response.getWriter().print(jsonArray);
		// System.out.println(jsonArray);
		// // } catch (Exception ex) {
		// JSONROOT.put("Result", "ERROR");
		// JSONROOT.put("Message", ex.getMessage());
		// String error = gson.toJson(JSONROOT);
		// response.getWriter().print(error);
		//
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int Approver1,Approver2;
//		String appid = request.getParameter("appid");
		AppModel uapp = new AppModel();
		uapp.setType(Integer.parseInt(request.getParameter("type")));
		uapp.setStartdate(request.getParameter("startdate"));
		uapp.setEnddate(request.getParameter("enddate"));
		uapp.setEnddate(request.getParameter("enddate"));
		uapp.setApplicabledays(Integer.parseInt(request.getParameter("workingdays")));
		uapp.setEmpid(testid);
		Approver1=Integer.parseInt(request.getParameter("approver1"));
		Approver2=Integer.parseInt(request.getParameter("approver2"));
		
		/* uapp.setApprover1(Integer.parseInt(request.getParameter("approver1")));
		uapp.setApprover2(Integer.parseInt(request.getParameter("approver2"))); */
		uapp.setApprover1(Approver1);
		uapp.setApprover2(Approver2);
		uapp.setComment(request.getParameter("comment"));
		String name=request.getParameter("fname");	
		//uapp.setStatus(Boolean.valueOf(request.getParameter("status")));
		if (appid>0) {
			uapp.setAppid(appid);
			cruddao.updateApplication(uapp);
			testid=0;
			appid=0;
			response.sendRedirect("IndexApplication.jsp");		
		}
		else {
			String port="587";
			String subject="Leave Application by "+name;
			String message="Hello,\n I "+name+" would like to apply for leave from "+request.getParameter("startdate")+" to "+request.getParameter("enddate")+" \n Please do the needful";
			String host = "smtp.gmail.com";
			String user = "lms.atidanmumbai@gmail.com";
			String pass = "Atidan@123";
	
			String approver1email=cruddao.getEmailbyId(Approver1);
			String approver2email=cruddao.getEmailbyId(Approver2);
			String toAddress1=approver1email;
			String toAddress2=approver2email;
			 int i = cruddao.addApplication(uapp,testid);
			if (i > 0) {
//		     String suc = "success";
//		     response.getWriter().write(suc);
try {
					sm.sendEmail(host, port, user, pass, approver1email, subject, message);
					sm.sendEmail(host, port, user, pass, approver2email, subject, message);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Leave Appliction added successfully');");  
				out.println("location='IndexApplication.jsp';");
				out.println("</script>");
				  testlog.info("application added successfully");
			}		
		}
			//	doGet(request, response);
	}
}
