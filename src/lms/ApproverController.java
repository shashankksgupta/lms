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


@WebServlet("/ApproverController")
public class ApproverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApproverCrud approvercrud = new ApproverCrud();
	String forward = "";
	int aid;

   
    public ApproverController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		List<ApproverModel> approverlist = new ArrayList<ApproverModel>();
		if (action.equals("list")) {
			approverlist = approvercrud.getAllApprovers();
			request.setAttribute("approvers", approverlist);
			forward = "/ApproverList.jsp";
		} else if (action.equalsIgnoreCase("edit")) {
			forward = "/Approver.jsp";
			aid = Integer.parseInt(request.getParameter("aid"));
			ApproverModel approver = approvercrud.getApproverById(aid);
			request.setAttribute("approvers", approver);			
		} else if (action.equalsIgnoreCase("delete")) {
			int aid = Integer.parseInt(request.getParameter("aid"));
			approvercrud.deleteApprover(aid);
			forward = "/ApproverList.jsp";
			request.setAttribute("approvers", approvercrud.getAllApprovers());
		} else {
			forward = "/Approver.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApproverModel uapprover = new ApproverModel();
		uapprover.setEid(Integer.parseInt(request.getParameter("fname")));
		uapprover.setApproverid(Integer.parseInt(request.getParameter("aname")));
		//  uapprover.setEname(request.getParameter("fname"));
     	//uapprover.setAname(request.getParameter("aname"));
		
		if (aid > 0) {
			uapprover.setAid(aid);
			approvercrud.updateApprover(uapprover);
			aid=0;
			response.sendRedirect("IndexApprover.jsp");
		} else {
			int i = approvercrud.addApprover(uapprover);
			if (i > 0) {
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Approver added successfully');");  
				out.println("location='IndexApprover.jsp';");
				out.println("</script>");
				
			}
		}

		
		//doGet(request, response);
	}

}
