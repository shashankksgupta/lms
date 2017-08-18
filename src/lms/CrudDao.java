package lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class CrudDao {

	final static Logger testlog = Logger.getLogger(CrudDao.class);

	private Connection conn = null;
	private PreparedStatement pStmt;

	public CrudDao() {
		conn = DAO.getConnection();
	}

	public int addApplication(AppModel mod,int eid) {
		int i = 0;
		// String insertQuery = "INSERT INTO
		// lms.applicationmaster(typeid,startdate,enddate,comment,appprover1id,approver2id)
		// VALUES
		// ("+mod.getType()+",'"+mod.getStartdate()+"','"+mod.getEnddate()+"','"+mod.getComment()+"','"+mod.getApprover1()+"','"+mod.getApprover2()+"')";
		String insertQuery = "INSERT INTO lms.applicationmaster(empid,typeid,startdate,enddate,numberofdays,applieddate,comment,approver1id,approver2id) VALUES ('" + mod.getEmpid() + "',"
				+ mod.getType() + ",'" + mod.getStartdate() + "','" + mod.getEnddate() + "','" + mod.getApplicabledays()
				+ "',now(),'" + mod.getComment() + "','" + mod.getApprover1() + "','" + mod.getApprover2() + "')";

		// System.out.println(insertQuery);
		try {
			pStmt = conn.prepareStatement(insertQuery);
			// pStmt.setInt(1,);
			// pStmt.setString(2,);
			// pStmt.setString(3, );
			// pStmt.setString(4, );
			// pStmt.setString(5, );
			// pStmt.setInt(6,);
			// pStmt.setInt(7,);
			// pStmt.setInt(8,);
			i = pStmt.executeUpdate();
			testlog.error("application inserted");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("application cannot be deleted");
		}

		return i;

	}

	public void deleteApplication(int appid) {
		String deleteQuery = "DELETE FROM lms.applicationmaster WHERE appid = ?";
		try {
			pStmt = conn.prepareStatement(deleteQuery);
			pStmt.setInt(1, appid);
			int i = pStmt.executeUpdate();
				testlog.info("application deleted successfully");
		

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("application cannot be deleted");
		}
	}

	public void updateApplication(AppModel uapp) {

		//String updateQuery = "UPDATE lms.applicationmaster SET typeid=?, approver1id= ?, approver2id = ?,comment=?, startdate=?,enddate=?  WHERE  appid= ?";
		String updateQuery="UPDATE lms.applicationmaster SET typeid=?, approver1id= ?, approver2id = ?,comment=?, startdate='" + uapp.getStartdate() + "',enddate='" + uapp.getEnddate() + "' WHERE  appid= ?";
		try {
			pStmt = conn.prepareStatement(updateQuery);

			pStmt.setInt(1, uapp.getType());
			pStmt.setInt(2, uapp.getApprover1());
			pStmt.setInt(3, uapp.getApprover2());
			pStmt.setString(4, uapp.getComment());		
			pStmt.setInt(5, uapp.getAppid());
			int i = pStmt.executeUpdate();
			if (i > 0) {
				testlog.info("application updated successfully");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("application cannot be updated");
		}
	}

	public List<AppModel> getAllApplications() {
		List<AppModel> applications = new ArrayList<AppModel>();

		String query = "select appid,(select fname as ename from lms.employeemaster where lms.employeemaster.empid=lms.applicationmaster.empid),startdate,enddate,numberofdays,(select fname as approver1 from lms.employeemaster where lms.employeemaster.empid=lms.applicationmaster.approver1id),(select fname as approver2 from lms.employeemaster where lms.employeemaster.empid=lms.applicationmaster.approver2id),status,comment,applieddate,(select leavetype from lms.leavestypemaster where lms.applicationmaster.typeid=lms.leavestypemaster.leavetypeid),leaveid from lms.applicationmaster ORDER BY appid";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AppModel application = new AppModel();

				application.setAppid(rs.getInt("appid"));
				// int empid=rs.getInt("empid");
				// rs =stmt.executeQuery("Select fname from lms.employeemaster Where
				// eid='empid'");
				// String ename=rs.getString("fname");
				application.setEname(rs.getString("ename"));
				application.setStartdate(rs.getString("startdate"));
				application.setEnddate(rs.getString("enddate"));
				application.setApplicabledays(rs.getInt("numberofdays"));
				application.setApprover1name(rs.getString("approver1"));
				application.setApprover2name(rs.getString("approver2"));
				application.setStatus(rs.getBoolean("status"));
				application.setComment(rs.getString("comment"));
				application.setApplieddate(rs.getString("applieddate"));
				application.setTypeofleave(rs.getString("leavetype"));
				application.setLeaveid(rs.getInt("leaveid"));
				applications.add(application);
				testlog.info(" fetched all applications");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("error in fetching all applications");
		}
		return applications;
	}

	public AppModel getApplicationById(int appid) {

		AppModel application = new AppModel();
		String query = "SELECT * FROM lms.applicationmaster Where appid=?";
		try {

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, appid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				application.setAppid(rs.getInt("appid"));
				// int empid=rs.getInt("empid");
				// rs =stmt.executeQuery("Select fname from lms.employeemaster Where
				// eid='empid'");
				// String ename=rs.getString("fname");
				application.setEmpid(rs.getInt("empid"));
				application.setStartdate(rs.getString("startdate"));
				application.setEnddate(rs.getString("enddate"));
				application.setType(rs.getInt("typeid"));
				application.setApplicabledays(rs.getInt("numberofdays"));
				application.setLeaveid(rs.getInt("leaveid"));
				application.setApprover1(rs.getInt("approver1id"));
				application.setApprover2(rs.getInt("approver2id"));
				application.setStatus(rs.getBoolean("status"));
				application.setComment(rs.getString("comment"));
				testlog.info(" fetched  application for given employee");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			testlog.error("error in fetching employee application");
		}
		return application;
	}
	public String getEmailbyId(int empid) {
		String email=null;
		String emailquery="select email from lms.employeemaster where empid = ?";
		try {
			pStmt=conn.prepareStatement(emailquery);
			pStmt.setInt(1, empid);
			ResultSet rs=pStmt.executeQuery();
			while(rs.next()) {
				email=rs.getString("email");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}

}
