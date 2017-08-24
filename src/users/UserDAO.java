package users;

import java.sql.CallableStatement;
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

import locationbean.copy.LocationBean;

public class UserDAO {
	final Logger userLog= Logger.getLogger(UserDAO.class);
	int i = 0;
	Connection con = null;
	PreparedStatement ps = null;
	CallableStatement cs = null;

	public UserDAO() {
		con = DBConnection.getConnection();
		userLog.info("Connection sucessfully created and called");
	}

	public int addUser(EmployeeBean empBean) {
		try {
			cs = con.prepareCall("{call lms.insertemp(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// String sql = "INSERT INTO lms.employeemaster(fname, mname, lname, username,
			// password, address, mobile1, mobile2, enumber, departmentid, locationid,
			// designation, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,? )";

			cs.setString(1, empBean.getFname());
			cs.setString(2, empBean.getMname());
			cs.setString(3, empBean.getLname());
			cs.setString(4, empBean.getUsername());
			cs.setString(5, empBean.getPassword());
			cs.setString(6, empBean.getAddress());

			cs.setString(7, empBean.getMobile1());
			cs.setString(8, empBean.getMobile2());
			cs.setString(9, empBean.getEnumber());
			cs.setInt(10, empBean.getDepartid());
			cs.setInt(11, empBean.getLocationid());
			// ps.setInt(13, empBean.getApprover1());
			// ps.setInt(14, empBean.getApprover2());
			// ps.setInt(15, empBean.getApprover3());
			cs.setString(12, empBean.getDesignation());
			cs.setString(13, empBean.getEmail());
			cs.setString(14, "No");
			cs.setString(15, "No");
			i = cs.executeUpdate();
			userLog.info("Insert successfull into lms.employeemaster");

		} catch (SQLException e) {
			userLog.error("Error while inserting into lms.employeemaster " +e);
			e.printStackTrace();
		}
		return i;
	}

	public void deleteEmployee(int empid) {
		try {
			CallableStatement cs=con.prepareCall("{call lms.deleteemployee(?)}");
			//ps = con.prepareStatement("delete from lms.employeemaster where empid=?");
			// Parameters start with 1
			cs.setInt(1, empid);
			cs.execute();
			userLog.info("Delete Successfull from lms.employeemaster");
		} catch (SQLException e) {
			userLog.error("error while deleting "+e);
		}
	}

	public void updateEmployee(EmployeeBean eob) {
		try {
			ps = con.prepareStatement(
					"update lms.employeemaster set fname=?,mname=?,lname=?,username=?,password=?,address=?,mobile1=?,mobile2=?,enumber=?,departmentid=?,locationid=?,designation=?,email=? where empid=?");
			ps.setString(1, eob.getFname());
			ps.setString(2, eob.getMname());
			ps.setString(3, eob.getLname());
			ps.setString(4, eob.getUsername());
			ps.setString(5, eob.getPassword());
			ps.setString(6, eob.getAddress());

			ps.setString(7, eob.getMobile1());
			ps.setString(8, eob.getMobile2());
			ps.setString(9, eob.getEnumber());
			ps.setInt(10, eob.getDepartid());
			ps.setInt(11, eob.getLocationid());
			// ps.setInt(13, eob.getApprover1());
			// ps.setInt(14, eob.getApprover2());
			// ps.setInt(15, eob.getApprover3());
			ps.setString(12, eob.getDesignation());
			ps.setString(13, eob.getEmail());
			ps.setInt(14, eob.getEmpid());
			ps.executeUpdate();
			userLog.info("Update Successfull to lms.employeemaster");
		} catch (SQLException e) {
			userLog.error("Error while updating lms.employeemaster" + e) ;
			
		}
	}

	public List<EmployeeBean> getAllEmployees() {
		List<EmployeeBean> emp = new ArrayList<EmployeeBean>();
		List<LocationBean> lob = new ArrayList<LocationBean>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"select * from lms.employeemaster inner join lms.locationmaster on lms.employeemaster.locationid = lms.locationmaster.locationid inner join lms.department on lms.employeemaster.departmentid = lms.department.did");
			while (rs.next()) {
				EmployeeBean emb = new EmployeeBean();
				LocationBean ln = new LocationBean();
				emb.setEmpid(rs.getInt("empid"));

				emb.setFname(rs.getString("fname"));
				emb.setMname(rs.getString("mname"));
				emb.setLname(rs.getString("lname"));

				emb.setUsername(rs.getString("username"));
				emb.setPassword(rs.getString("password"));
				emb.setAddress(rs.getString("address"));
				emb.setEmail(rs.getString("email"));
				emb.setMobile1(rs.getString("mobile1"));
				emb.setMobile2(rs.getString("mobile2"));
				emb.setEnumber(rs.getString("enumber"));
				emb.setDepartid(rs.getInt("did"));
				emb.setLocationid(rs.getInt("locationid"));
				// emb.setApprover1(rs.getInt("approverid1"));
				// emb.setApprover2(rs.getInt("approverid2"));
				// emb.setApprover3(rs.getInt("approverid3"));
				emb.setDesignation(rs.getString("designation"));
				emb.setLocation(rs.getString("locationname"));
				emb.setDepartment(rs.getString("dname"));
				emp.add(emb);
				userLog.info("Fetch Successfull from lms.employeemaster");

			}
		} catch (SQLException e) {
			userLog.error("Error while fetching from from lms.employeemaster");
		}

		return emp;
	}

	public EmployeeBean getEmpById(int empId) {
		EmployeeBean emb = new EmployeeBean();
		try {
			ps = con.prepareStatement(
					"select * from lms.employeemaster inner join lms.locationmaster on lms.employeemaster.locationid = lms.locationmaster.locationid inner join lms.department on lms.employeemaster.departmentid = lms.department.did where empid = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				emb.setEmpid(rs.getInt("empid"));
				emb.setFname(rs.getString("fname"));
				emb.setMname(rs.getString("mname"));
				emb.setLname(rs.getString("lname"));
				emb.setUsername(rs.getString("username"));
				emb.setPassword(rs.getString("password"));
				emb.setAddress(rs.getString("address"));
				emb.setEmail(rs.getString("email"));
				emb.setMobile1(rs.getString("mobile1"));
				emb.setMobile2(rs.getString("mobile2"));
				emb.setEnumber(rs.getString("enumber"));
				emb.setDepartid(rs.getInt("departmentid"));
				emb.setLocationid(rs.getInt("locationid"));
				emb.setDesignation(rs.getString("designation"));
				emb.setLocationid(rs.getInt("locationid"));
				emb.setLocation(rs.getString("locationname"));
				emb.setDepartid(rs.getInt("did"));
				emb.setDepartment(rs.getString("dname"));
				userLog.info("Fetch Successfull from lms.employeemaster");

			}

		} catch (SQLException e) {
			userLog.info("Error while Fetching from lms.employeemaster" +e);
		}

		return emb;
	}

	public EmployeeBean getEmpByColumn(String column) {
		EmployeeBean emb = new EmployeeBean();
		try {
			ps = con.prepareStatement("SELECT * FROM lms.employeemaster where fname = ?");
		ps.setString(1, column);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				emb.setEmpid(rs.getInt("empid"));
				emb.setFname(rs.getString("fname"));
				emb.setMname(rs.getString("mname"));
				emb.setLname(rs.getString("lname"));
				emb.setUsername(rs.getString("username"));
				emb.setPassword(rs.getString("password"));
				emb.setAddress(rs.getString("address"));
				emb.setEmail(rs.getString("email"));
				emb.setMobile1(rs.getString("mobile1"));
				emb.setMobile2(rs.getString("mobile2"));
				emb.setEnumber(rs.getString("enumber"));
				emb.setDepartid(rs.getInt("departmentid"));
				emb.setLocationid(rs.getInt("locationid"));
				// emb.setApprover1(rs.getInt("approverid1"));
				// emb.setApprover2(rs.getInt("approverid2"));
				// emb.setApprover3(rs.getInt("approverid3"));
				emb.setDesignation(rs.getString("designation"));
				emb.setLocationid(rs.getInt("locationid"));
				emb.setLocation(rs.getString("locationname"));
				emb.setDepartid(rs.getInt("departmentid"));
				emb.setDepartment(rs.getString("departmentname"));
				userLog.info("Fetch Successfull from lms.employeemaster");
			}

		} catch (SQLException e) {
			userLog.error("Error while Fetching from lms.employeemaster");
		}

		return emb;
	}

}
