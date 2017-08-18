package lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class HolidaysCrud {

	private Connection conn = null;
	private PreparedStatement pStmt;
	 int i = 0;
	 final static Logger testlog = Logger.getLogger(HolidaysCrud.class);
	public HolidaysCrud()
	{
		conn = DAO.getConnection();	
	}
public int addHoliday(HolidaysModel mod) {	
	
	String insertQuery = "INSERT INTO lms.holidaymaster(hname,hdate) VALUES ('"+mod.getHname()+"','"+mod.getHdate()+"')";
		try {
			pStmt = conn.prepareStatement(insertQuery);
			i=pStmt.executeUpdate();
			testlog.info("holiday inserted succesfully");
		}
		catch (SQLException e) {
				e.printStackTrace();
				testlog.error(e);
		}
		return i;
	     
	}
	
	public void deleteHoliday(int hid) {
	    String deleteQuery = "DELETE FROM lms.holidaymaster WHERE hid = ?";
	    try {
	            pStmt = conn.prepareStatement(deleteQuery);
	            pStmt.setInt(1, hid);
	            pStmt.executeUpdate();
				testlog.info(" holiday deleted successfully");
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
				testlog.error("error in deleting holiday");
	    }    
	}
	
	public void updateHoliday(HolidaysModel uholiday)  {

	    String updateQuery = "UPDATE lms.holidaymaster SET hname= ?  WHERE  hid= ?";
	    try {
	            pStmt = conn.prepareStatement(updateQuery);             
	            pStmt.setString(1, uholiday.getHname());
	            pStmt.setInt(2, uholiday.getHid());
	            pStmt.executeUpdate();
	            testlog.info("holiday updated successfully");
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
				testlog.error("error in updating holiday");
	    }
	}
	
	public List<HolidaysModel> getAllHolidays() {
	    List<HolidaysModel> holidays = new ArrayList<HolidaysModel>();

	    String query = "SELECT * FROM lms.holidaymaster ORDER BY hid";
	    try {
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                    HolidaysModel holiday = new HolidaysModel();
	                    		
	                    holiday.setHid(rs.getInt("hid"));
	                    holiday.setHname(rs.getString("hname")); 
	                    holiday.setHdate(rs.getString("hdate"));
	                    holidays.add(holiday);
	                    testlog.info(" holiday list fetched successfully");
	            }
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            testlog.error("error in fetching holidays list");
	    }
	    return holidays;
	}
	public HolidaysModel getHolidaytById(int hid) {
	  
		HolidaysModel holiday = new HolidaysModel();
	    String query = "SELECT * FROM lms.holidaymaster Where hid=?";
	    try {
	    	
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setInt(1,hid);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {             		
	                    holiday.setHid(rs.getInt("hid"));                 
	                    holiday.setHname(rs.getString("hname"));
	                    holiday.setHdate(rs.getString("hdate"));
	                    testlog.info(" holiday found successfully");
	            }
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            testlog.error("cannot find holiday");
	    }
	    return holiday;
	}


	
}
