package lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DepCrud {
	
	private Connection conn=null;
	private PreparedStatement pStmt;
	int i=0;
 final static Logger testlog = Logger.getLogger(DepCrud.class);
	public DepCrud()
	 {
		 conn = DAO.getConnection();
	 }
	
	public int addDepartment(DepModel mod) {
		int i=0;	
	 
		
		String insertQuery = "INSERT INTO lms.department(dname) VALUES ('"+mod.getDname()+"')";
		try {
			pStmt = conn.prepareStatement(insertQuery);
			i=pStmt.executeUpdate();
			testlog.info("department added succesfully");
		}
		catch (SQLException e) {
				e.printStackTrace();
				testlog.error("error in adding department");
		}
	     return i;
	}
	
	public void deleteDepartment(int deptid) {
	    String deleteQuery = "DELETE FROM lms.department WHERE did = ?";
	    try {
	            pStmt = conn.prepareStatement(deleteQuery);
	            pStmt.setInt(1, deptid);
	            pStmt.executeUpdate();
	            testlog.info("department deleted succesfully");
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            testlog.info("error in deleting department");
	    }
	}
	
	public void updateDepartment(DepModel udep)  {

	    String updateQuery = "UPDATE lms.department SET dname= ?  WHERE  did= ?";
	    try {
	            pStmt = conn.prepareStatement(updateQuery);             
	           
	            pStmt.setString(1, udep.getDname());
	            pStmt.setInt(2, udep.getDid());
	            pStmt.executeUpdate();
	            testlog.info("department updated succesfully");

	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            testlog.info("error in uupdating department ");
	    }
	}

	public List<DepModel> getAllDepartments() {
	    List<DepModel> departments = new ArrayList<DepModel>();

	    String query = "SELECT * FROM lms.department ORDER BY did";
	    try {
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                    DepModel department = new DepModel();
	                    		
	                    department.setDid(rs.getInt("did"));
	                    department.setDname(rs.getString("dname"));    
	                    departments.add(department);
	                    testlog.info("department list fethched succesfully");
	            }
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            testlog.info("error in fetching department list");
	    }
	    return departments;
	}
	public DepModel getDepartmentById(int deptid) {
	  
		DepModel department = new DepModel();
	    String query = "SELECT * FROM lms.department Where did=?";
	    try {
	    	
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setInt(1,deptid);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {             		
	                    department.setDid(rs.getInt("did"));                 
	                    department.setDname(rs.getString("dname")); 
	                    testlog.info("department fetched succesfully");        
	            }
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            testlog.info("error in fetching department"); 
	    }
	    return department;
	}


	
}
