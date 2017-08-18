package lms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ApproverCrud {

	private Connection conn = null;
	private PreparedStatement pStmt;
	Statement stmt;
	int i = 0;
	final static Logger testlog = Logger.getLogger(ApproverCrud.class);
	public ApproverCrud() {
		conn = DAO.getConnection();
	}

	public int addApprover(ApproverModel mod) {
		String insertQuery = "INSERT INTO lms.approvermaster(eid,approverid) VALUES ('" + mod.getEid() + "','"
				+ mod.getApproverid() + "')";
		try {
			pStmt = conn.prepareStatement(insertQuery);
			i = pStmt.executeUpdate();
			testlog.info("approver inserted");
		} catch (SQLException e) {
			e.printStackTrace();
			testlog.error("error in approver insertion");
		}
		return i;
	}

	public void deleteApprover(int aid) {
		String deleteQuery = "DELETE FROM lms.approvermaster WHERE aid = ?";
		try {
			pStmt = conn.prepareStatement(deleteQuery);
			pStmt.setInt(1, aid);
			pStmt.executeUpdate();
			testlog.info("approver deleted successfully");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("approver cannot be deleted");
		}
	}

	public void updateApprover(ApproverModel uapprover) {

		String updateQuery = "UPDATE lms.approvermaster SET eid= ?,approverid=? WHERE  aid= ?";
		try {
			pStmt = conn.prepareStatement(updateQuery);
			pStmt.setInt(1, uapprover.getEid());
			pStmt.setInt(2, uapprover.getApproverid());
			pStmt.setInt(3, uapprover.getAid());
			pStmt.executeUpdate();
			testlog.info("approver updation successfully done");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.info(" error in approver updation");
		}
	}

	public List<ApproverModel> getAllApprovers() {
		List<ApproverModel> approvers = new ArrayList<ApproverModel>();
		String query = "select lms.approvermaster.aid,(select fname from lms.employeemaster where lms.employeemaster.empid=lms.approvermaster.eid),(select fname as approvername from lms.employeemaster where lms.approvermaster.approverid=lms.employeemaster.empid) from  lms.approvermaster order by aid";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ApproverModel approver = new ApproverModel();
				approver.setAid(rs.getInt("aid"));
				approver.setEname(rs.getString("fname"));
				approver.setAname(rs.getString("approvername"));
			approvers.add(approver);
			testlog.info("approver list festched");
		}	
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("error in fetching approver list");
		}
		return approvers;
	}

	public ApproverModel getApproverById(int aid) {

		ApproverModel approver = new ApproverModel();
		try {
			stmt = conn.createStatement();
			String query = "select lms.approvermaster.aid,(select fname from lms.employeemaster where lms.employeemaster.eid=lms.approvermaster.eid),(select fname from lms.employeemaster where lms.approvermaster.approverid=lms.employeemaster.eid) from  lms.approvermaster";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				approver.setAid(rs.getInt("aid"));
				approver.setEname(rs.getString("fname"));
				approver.setAname(rs.getString("fname"));	
				testlog.info("approver got for the given employee");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("approver couldnt be fetched for the given employee");
		}
		return approver;
	}
	public List<ApproverModel> getApproverByColumn(int empid) {
		List<ApproverModel> appro = new ArrayList<ApproverModel>();
		ApproverModel approver = new ApproverModel();
		try {
			stmt = conn.createStatement();
			
			String query = "select lms.approvermaster.aid,lms.approvermaster.approverid,(select fname from lms.employeemaster where lms.employeemaster.empid=lms.approvermaster.eid),(select fname as approvername from lms.employeemaster where lms.approvermaster.approverid=lms.employeemaster.empid) from  lms.approvermaster where lms.approvermaster.eid = (Select empid from lms.employeemaster where empid = ?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,empid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				approver.setAid(rs.getInt("aid"));
				approver.setEname(rs.getString("fname"));
				approver.setAname(rs.getString("approvername"));
				approver.setApproverid(rs.getInt("approverid"));
				appro.add(approver);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return appro;
	}

}
