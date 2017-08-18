package processing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import leave.LeaveDAO;
import leavebean.LeaveBean;


@WebServlet("/LeaveLogic")
public class LeaveLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LeaveDAO dao;
	final Logger LeaveLogicLog=Logger.getLogger(LeaveLogic.class);
	public LeaveLogic() {
		super();
		dao= new LeaveDAO();
		LeaveLogicLog.info("Successfully initialized DAO class");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("action").equalsIgnoreCase("list")){
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LeaveLogicLog.info("Inside Post Method");
		LeaveBean leb=new LeaveBean();
		leb.setLeavetype((request.getParameter("leavetype")));
        leb.setAllocateddays((Integer.parseInt(request.getParameter("allocateddays"))));
        int j=dao.addLeave(leb);
        if(j>0) {
       	 String suc="success";
				response.getWriter().write(suc);
				
        }

	}

}
