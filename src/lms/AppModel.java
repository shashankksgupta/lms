package lms;

import java.sql.Date;

public class AppModel {
	
	private int type;
	private String startdate;
	private String enddate;
	private String comment;
	private int approver1;
	private int approver2;
	private int appid;
	private int empid;
	private int applicabledays;
	private int leaveid;
	private boolean status;
	private String applieddate;
	String approver1name;
	String approver2name;
	String typeofleave;
	String ename;
	
	
	
	
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getApprover1() {
		return approver1;
	}
	public void setApprover1(int approver1) {
		this.approver1 = approver1;
	}
	public int getApprover2() {
		return approver2;
	}
	public void setApprover2(int approver2) {
		this.approver2 = approver2;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getApplicabledays() {
		return applicabledays;
	}
	public void setApplicabledays(int applicabledays) {
		this.applicabledays = applicabledays;
	}
	public int getLeaveid() {
		return leaveid;
	}
	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getApplieddate() {
		return applieddate;
	}
	public void setApplieddate(String applieddate) {
		this.applieddate = applieddate;
	}
	public String getApprover1name() {
		return approver1name;
	}
	public void setApprover1name(String approver1name) {
		this.approver1name = approver1name;
	}
	public String getApprover2name() {
		return approver2name;
	}
	public void setApprover2name(String approver2name) {
		this.approver2name = approver2name;
	}
	public String getTypeofleave() {
		return typeofleave;
	}
	public void setTypeofleave(String typeofleave) {
		this.typeofleave = typeofleave;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

}
