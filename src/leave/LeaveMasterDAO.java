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
import com.employeebean.EmployeeBean;

import leavebean.LeavesMasterBean;

public class LeaveMasterDAO {

	int i = 0;
	int j = 0;
	Connection con = null;
	PreparedStatement ps = null;
	final Logger leaveMasterLog = Logger.getLogger(LeaveMasterDAO.class);

	public LeaveMasterDAO() {
		con = DBConnection.getConnection();
		leaveMasterLog.info("Connection Sucessfully Retrived");
	}

	public int addLeaveMaster(LeavesMasterBean lb) {
		int i = 0;

		String sql = "insert into lms.leavesmaster(empid,annualalloted,annualconsumed,sickalloted,sickconsumed,wfhalloted,wfhconsumed) values(?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, lb.getEmpid());
			ps.setInt(2, lb.getAnnualalloted());
			ps.setInt(3, lb.getAnnualconsumed());
			ps.setInt(4, lb.getSickalloted());
			ps.setInt(5, lb.getSickconsumed());
			ps.setInt(6, lb.getWfhalloted());
			ps.setInt(7, lb.getWfhconsumed());
			i = ps.executeUpdate();
			leaveMasterLog.info("Insert Successful into lms.leavesmaster");
		} catch (SQLException e) {
			leaveMasterLog.error("Error while inserting into ms.leavesmaster " +e);
		
		}
		return i;
	}

	public List<LeavesMasterBean> getAllLeaves() {
		List<LeavesMasterBean> lm = new ArrayList<LeavesMasterBean>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from lms.leavesmaster inner join lms.employeemaster on lms.leavesmaster.empid = lms.employeemaster.empid ");
			while (rs.next()) {
				LeavesMasterBean lmb = new LeavesMasterBean();
				lmb.setEmpid(rs.getInt("empid"));
				lmb.setAnnualalloted(rs.getInt("annualalloted"));
				lmb.setAnnualconsumed(rs.getInt("annualconsumed"));
				lmb.setSickalloted(rs.getInt("sickalloted"));
				lmb.setSickconsumed(rs.getInt("sickconsumed"));
				lmb.setWfhalloted(rs.getInt("wfhalloted"));
				lmb.setWfhconsumed(rs.getInt("wfhconsumed"));
				lmb.setFname(rs.getString("fname"));
				lmb.setLname(rs.getString("lname"));
		
				lm.add(lmb);
				 leaveMasterLog.info("Fetch successfull from lms.leavesmaster");
			}
		} catch (SQLException e) {
			leaveMasterLog.error("Error while Fetching from ms.leavesmaster " +e);
		}

		return lm;
	}
	public LeavesMasterBean getLeavesByEmpId(int empId) {
        LeavesMasterBean lmb = new LeavesMasterBean();
        try {
            ps= con.prepareStatement("select * from lms.leavesmaster where empid=?");
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	lmb.setEmpid(rs.getInt("empid"));
				lmb.setAnnualalloted(rs.getInt("annualalloted"));
				lmb.setAnnualconsumed(rs.getInt("annualconsumed"));
				lmb.setSickalloted(rs.getInt("sickalloted"));
				lmb.setSickconsumed(rs.getInt("sickconsumed"));
				lmb.setWfhalloted(rs.getInt("wfhalloted"));
				lmb.setWfhconsumed(rs.getInt("wfhconsumed"));
            }
            
            leaveMasterLog.info("Fetch successfull from lms.leavesmaster");
        } catch (SQLException e) {
        	leaveMasterLog.error("Error while Fetching from ms.leavesmaster " +e);
        }

        return lmb;
    }
	public void updateLeavesMaster(LeavesMasterBean lmb) {
        try {
            ps = con.prepareStatement("update lsm.leavesmaster set annualalloted=?,annualconsumed=?,sickalloted=?,sickconsumed=?,wfhalloted=?,wfhconsumed=? where empid=?");
            ps.setInt(1, lmb.getAnnualalloted());
            ps.setInt(2, lmb.getAnnualconsumed());
            ps.setInt(3, lmb.getSickalloted());
            ps.setInt(4, lmb.getSickconsumed());
            ps.setInt(5, lmb.getWfhalloted());
            ps.setInt(6, lmb.getWfhconsumed());
            ps.setInt(6, lmb.getEmpid());
   
           ps.executeUpdate();
           leaveMasterLog.info("Update successfull into lms.leavesmaster");
        } catch (SQLException e) {
        	leaveMasterLog.error("Error while Updating");
            
        }
    }
	public void DeleteLeavesMaster(int empid) {
        try {
            String sql="Delete from lms.leavesmaster where empid= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, empid);
   
           ps.executeUpdate();
           leaveMasterLog.info("Delete Successfull fro lms.leavesmaster");
        } catch (SQLException e) {
        	leaveMasterLog.error("Error while Deleting");
            
        }
    }
	
}
