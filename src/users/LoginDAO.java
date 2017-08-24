package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.controller.DBConnection;
import com.employeebean.*;

public class LoginDAO {
	String username, password;
	DBConnection DBCon;
	Connection con=null;
		
	public EmployeeBean doLogin(String username, String password) {
		DBCon=new DBConnection();
		EmployeeBean employee = new EmployeeBean();
		employee.setUsername(username);
		employee.setPassword(password);
		String query = "Select * from lms.employeemaster inner join lms.rolesmaster on lms.employeemaster.empid=lms.rolesmaster.empid where lms.employeemaster.username=? and lms.employeemaster.password=?";
		con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, employee.getUsername());
			ps.setString(2,employee.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				employee.setEmpid(rs.getInt("empid"));
				employee.setFname(rs.getString("fname"));
				employee.setLname(rs.getString("lname"));
				employee.setIsadmin(rs.getString("isadmin"));
				employee.setIsapprover("isapprover");
				employee.setDesignation("designation");
				employee.setEmail("email");
				employee.setEnumber("enumber");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employee;

	}
}
