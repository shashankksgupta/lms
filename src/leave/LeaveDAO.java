package leave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.controller.DBConnection;

import leavebean.LeaveBean;
import locationbean.copy.LocationBean;

public class LeaveDAO {
	int i = 0;
	int j = 0;
	Connection con = null;
	PreparedStatement ps = null;
	final Logger leaveLog= Logger.getLogger(LeaveDAO.class);
	

	public LeaveDAO() {
		con = DBConnection.getConnection();
		leaveLog.info("Sucessfully got connection in LeaveDAO class");
		
	}

	public int addLeave(LeaveBean leave) {
		try {
			String sql = "INSERT INTO lms.leavestypemaster (leavetype) VALUES (?)";
			ps = con.prepareStatement(sql);
			String leaveType = leave.getLeavetype();
			
			ps.setString(1, leaveType);
			

			i = ps.executeUpdate();
			leaveLog.info("Insert of LeaveType Successfull");
			
//			if (i > 0) {
//				Statement stm = null;
//				String colcreate = "Alter table lms.leavesmaster add " + leaveType + "Alloted integer, add " + leaveType
//						+ "Consumed numeric(5);";
//				stm = con.createStatement();
//				j = stm.executeUpdate(colcreate);
//				if (j > 0) {
//					System.out.println("Success");
//				}
//			}
		} catch (SQLException e) {
			leaveLog.error("Error While Inserting Leave Type "+e);
		
		}
		return j;
	}
	public List<LeaveBean> getAllLeaves() {
        List<LeaveBean> leavetype = new ArrayList<LeaveBean>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from lms.leavestypemaster order by leavetypeid");
            while (rs.next()) {
                LeaveBean leb = new LeaveBean();
                leb.setLeavetypeid((rs.getInt("leavetypeid")));
                leb.setLeavetype(rs.getString("leavetype"));
               
               leavetype.add(leb); 
            }
        } catch (SQLException e) {
        	leaveLog.info("Error While Fetching all Leave Types "+e);
        }

        return leavetype;
    }
	



}
