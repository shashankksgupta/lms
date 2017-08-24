package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.controller.DBConnection;
import com.employeebean.EmployeeBean;
import com.employeebean.RolesBean;

public class RolesDAO {
	int i = 0;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs=null;

	public RolesDAO() {
		con = DBConnection.getConnection();
	}

	public int AddRole(RolesBean roleBean) {
		try {
			String sql = "INSERT INTO lms.rolesmaster(empid, isadmin, isapprover)VALUES (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roleBean.getEmpid());
			ps.setString(2, roleBean.getIsadmin());
			ps.setString(3, roleBean.getIsapprover());
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public void deleteRole(int empid) {
		try {
			ps = con.prepareStatement("delete from lms.rolesmaster where empid=?");
			// Parameters start with 1
			ps.setInt(1, empid);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRole(RolesBean rob) {
		try {
			ps = con.prepareStatement("update lms.rolesmaster set isadmin=?, isapprover=? where empid=?");
			ps.setString(1, rob.getIsadmin());
			ps.setString(2, rob.getIsapprover());
			ps.setInt(3, rob.getEmpid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RolesBean> getAllRoles() {
		List<RolesBean> role = new ArrayList<RolesBean>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from lms.rolesmaster inner join lms.employeemaster on lms.rolesmaster.empid = lms.employeemaster.empid");
			while (rs.next()) {
				RolesBean rob = new RolesBean();
				rob.setRoleid(rs.getInt("roleid"));
				rob.setEmpid(rs.getInt("empid"));
				rob.setIsadmin(rs.getString("isadmin"));
				rob.setIsapprover(rs.getString("isapprover"));
				rob.setFname(rs.getString("fname"));
				rob.setLname(rs.getString("lname"));
				role.add(rob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return role;
	}

	public RolesBean getRoleById(int empId) {
		RolesBean rob = new RolesBean();
		try {
			ps = con.prepareStatement("select * from lms.rolesmaster inner join lms.employeemaster on lms.rolesmaster.empid = lms.employeemaster.empid where lms.rolesmaster.empid=?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				rob.setRoleid(rs.getInt("roleid"));
				rob.setEmpid(rs.getInt("empid"));
				rob.setIsadmin(rs.getString("isadmin"));
				rob.setIsapprover(rs.getString("isapprover"));
				rob.setFname(rs.getString("fname"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rob;
	}
	public EmployeeBean getNameById(int empId) {
		EmployeeBean emp=new EmployeeBean();
		String query="Select fname,lname from lms.employeemaster where empid=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, empId);
			rs=ps.executeQuery();
			while(rs.next()) {
				emp.setFname(rs.getString("fname"));
				emp.setLname(rs.getString("lname"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return emp;
		
	}

}
