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


@WebServlet("/CrudDepart")
public class CrudDepart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn=null;
	private PreparedStatement pStmt;
	int i=0;
       
   
    public CrudDepart() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		conn = DAO.getConnection();
		
		String dename=request.getParameter("departname");
		String insertQuery = "INSERT INTO lms.department(dname) VALUES ('"+dename+"')";
		try {
			pStmt = conn.prepareStatement(insertQuery);
			i=pStmt.executeUpdate();
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
	     if(i>0)
		{
			String suc="success";
			response.getWriter().write(suc);
    	}
	          doGet(request, response);
	}

}
