package lms;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("/CrudApprover")
public class CrudApprover extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn = null;
	private PreparedStatement pStmt;
	 int i = 0;
	 final static Logger testlog = Logger.getLogger(CrudApprover.class);
    
    public CrudApprover() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		conn = DAO.getConnection();
		
		String ename=request.getParameter("ename");
		String aname=request.getParameter("aname");
		
		CallableStatement stmt;
		try {
			stmt = conn.prepareCall("{call insertapprover(?,?)}");
			stmt.setString(1, ename);
			stmt.setString(2, aname);
			if(stmt.execute());
			{
				String suc="success";
				response.getWriter().write(suc);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
doGet(request, response);
	}

}
