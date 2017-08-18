package com.employeebean;

public class RolesBean {
int roleid,empid;
String isadmin,isapprover,fname,lname;
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getIsadmin() {
	return isadmin;
}
public void setIsadmin(String isadmin) {
	this.isadmin = isadmin;
}
public String getIsapprover() {
	return isapprover;
}
public void setIsapprover(String isapprover) {
	this.isapprover = isapprover;
}

}
