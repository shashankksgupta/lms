package lms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CrudHolidays")
public class CrudHolidays extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private PreparedStatement pStmt;
	private int i = 0;

	public CrudHolidays() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		conn = DAO.getConnection();

		String hname1 = request.getParameter("hname");
		String hdate1 = request.getParameter("hdate");
		String insertQuery = "INSERT INTO lms.holidaymaster(hname,hdate) VALUES ('"+hname1+"','"+hdate1+"')";

		try {
			pStmt = conn.prepareStatement(insertQuery);
//			pStmt.setString(1, hname1);
//			pStmt.setString(2, hdate1);
			
			if (pStmt.execute()) {
				String str = "success";
				response.getWriter().write(str);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
