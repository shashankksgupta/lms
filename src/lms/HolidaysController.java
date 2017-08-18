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

@WebServlet("/HolidaysController")
public class HolidaysController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HolidaysCrud holidayscrud = new HolidaysCrud();
	String forward = "";
	int hid;

	public HolidaysController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		List<HolidaysModel> holidayslist = new ArrayList<HolidaysModel>();
		if (action.equals("list")) {
			holidayslist = holidayscrud.getAllHolidays();
			request.setAttribute("holidays", holidayslist);
			forward = "/HolidaysList.jsp";
		} else if (action.equalsIgnoreCase("edit")) {
			
			forward = "/Holidays.jsp";
			hid = Integer.parseInt(request.getParameter("hid"));
			HolidaysModel holiday = holidayscrud.getHolidaytById(hid);
			request.setAttribute("holidays", holiday);
			
		} else if (action.equalsIgnoreCase("delete")) {
			int hid = Integer.parseInt(request.getParameter("hid"));
			holidayscrud.deleteHoliday(hid);
			forward = "/HolidaysList.jsp";
			request.setAttribute("holidays", holidayscrud.getAllHolidays());
		} else {
			forward = "/Holidays.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HolidaysModel uholiday = new HolidaysModel();
		uholiday.setHname(request.getParameter("hname"));
		uholiday.setHdate(request.getParameter("hdate"));
		if (hid > 0) {
			uholiday.setHid(hid);
			holidayscrud.updateHoliday(uholiday);
			hid=0;
			response.sendRedirect("IndexHolidays.jsp");
		} else {
			int i = holidayscrud.addHoliday(uholiday);
			if (i > 0) {
//				String suc = "success";
//				response.getWriter().write(suc);
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Holiday added usccessfully');");  
				out.println("location='IndexHolidays.jsp';");
				out.println("</script>");
				
			}
		}

		// doGet(request, response);
	}
}
