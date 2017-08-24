package processing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import location.LocationDAO;
import locationbean.copy.LocationBean;

@WebServlet("/LocationLogic")
public class LocationLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LocationDAO dao;
	int locationId;
	public LocationLogic() {
		super();
		dao = new LocationDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("list")) {
			forward = "/listlocation.jsp";
			request.setAttribute("loc", dao.getAllLocations());

		} else if (action.equalsIgnoreCase("edit")) {

			forward = "/AddLocation.jsp";
		locationId = Integer.parseInt(request.getParameter("locationid"));

			LocationBean lobs = dao.getLocationById(locationId);
			request.setAttribute("lobs", lobs);
		} else if (action.equalsIgnoreCase("delete")) {
			int locid = Integer.parseInt(request.getParameter("locationid"));
			dao.deleteLocation(locid);
			forward = "/locindex.jsp";
			request.setAttribute("users", dao.getAllLocations());
		} else {
			forward = "/Registration.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LocationBean lob = new LocationBean();
//		locationid=request.getParameter("locationid");
		lob.setLocation((request.getParameter("locationname")));
		lob.setLocationAddress(request.getParameter("locationaddress"));
		if(locationId>0)
			
        {
			
			 lob.setLocationid(locationId);
	            dao.updateLocation(lob);
	            locationId=0;
//	          
	            response.sendRedirect("listlocation.jsp");
        }
        else
        {
			
            dao.addLocation(lob);
            response.sendRedirect("listlocation.jsp");
        }
        }

		}

	


