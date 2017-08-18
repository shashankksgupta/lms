package location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.controller.DBConnection;

import locationbean.copy.LocationBean;

public class LocationDAO {
	static int i = 0;
	static Connection con = null;
	static PreparedStatement ps = null;
	final Logger locationLog= Logger.getLogger(LocationDAO.class);
	public LocationDAO() {
		con = DBConnection.getConnection();
		locationLog.info("Successfully retrived connection in LocationDAO");
	}

	public int addLocation(LocationBean lob) {
		try {
			String sql = "INSERT INTO lms.locationmaster(locationname,locationaddress) VALUES (?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, lob.getLocation());
			ps.setString(2, lob.getLocationAddress());
		
			i = ps.executeUpdate();
			locationLog.info("Insert into lms.locationmaster successfull");
			ps.close();

		} catch (SQLException e) {
			locationLog.error("Error while inserting into lms.locationmaster "+e );
			
		}
		return i;
	}
	public void deleteLocation(int locId) {
        try {
            ps = con.prepareStatement("delete from lms.locationmaster where locationid=?");
            // Parameters start with 1
            ps.setInt(1, locId);
            ps.executeUpdate();
        	locationLog.info("Delete successfull");
        } catch (SQLException e) {
        	locationLog.error("Error while deleting from lms.locationmaster "+e);
            
        }
    }
	public void updateLocation(LocationBean lob) {
        try {
            ps = con.prepareStatement("update lms.locationmaster set locationname=?, locationaddress=? where locationid=?");
            ps.setString(1, lob.getLocation());
            ps.setString(2, lob.getLocationAddress());
            ps.setInt(3, lob.getLocationid());
           ps.executeUpdate();
       	locationLog.info("Update successfull into lms.locationmaster");
        } catch (SQLException e) {
           locationLog.error("Error while updating into lms.locationmaster " + e);
        }
    }
	 public List<LocationBean> getAllLocations() {
	        List<LocationBean> location = new ArrayList<LocationBean>();
	        try {
	            Statement statement = con.createStatement();
	            ResultSet rs = statement.executeQuery("select * from lms.locationmaster order by locationid");
	            while (rs.next()) {
	                LocationBean lob = new LocationBean();
	                lob.setLocationid(rs.getInt("locationid"));
	                lob.setLocation(rs.getString("locationname"));
	                lob.setLocationAddress(rs.getString("locationaddress"));
	               location.add(lob); 
	           	locationLog.info("Fetch successfull from lms.locationmaster ");
	            }
	        } catch (SQLException e) {
	        	locationLog.error("Fetch unsuccessfull from lms.locationmaster " +e);
	            
	        }

	        return location;
	    }
	 public LocationBean getLocationById(int locId) {
	        LocationBean lob = new LocationBean();
	        try {
	            ps= con.prepareStatement("select * from lms.locationmaster where locationid=?");
	            ps.setInt(1, locId);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                lob.setLocationid(rs.getInt("locationid"));
	                lob.setLocation(rs.getString("locationname"));
	                lob.setLocationAddress(rs.getString("locationaddress"));
	                
	            }
	        	locationLog.info("Fetch successfull from lms.locationmaster ");
	        } catch (SQLException e) {
	        	locationLog.error("Fetch unsuccessfull from lms.locationmaster " +e);
	        }

	        return lob;
	    }


    
}

