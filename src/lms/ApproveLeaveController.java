package lms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ApproveLeaveController")
public class ApproveLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrudDao cruddao = new CrudDao();
	int applicationid;
    public ApproveLeaveController() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action=request.getParameter("action");
		if (action.equals("list")) {
			
	
			HttpSession session=request.getSession();
			
			List<AppModel> applicationlist = new ArrayList<AppModel>();
			String aid=String.valueOf(session.getAttribute("empid"));
			int approverid=Integer.parseInt(aid);
			applicationlist = cruddao.getAllApplicationsByAid(approverid);
			request.setAttribute("applist", applicationlist);	
			
			forward = "/ApproveLeave.jsp";
		}
		else if(action.equals("approve")) {
			
			
			
			applicationid=Integer.parseInt(request.getParameter("appid"));
			List<Integer> type=new ArrayList<Integer>();
			type=cruddao.getLeaveDetails(applicationid);			
			int nod=type.get(0);
			int typeid=type.get(1);
			
			cruddao.approvebyid(applicationid,nod,typeid);
			forward="/ApproveLeave.jsp";
			
			
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
