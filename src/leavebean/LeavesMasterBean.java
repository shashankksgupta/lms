package leavebean;

public class LeavesMasterBean {
int empid,leavesid,annualalloted,annualconsumed,sickalloted,sickconsumed,wfhalloted,wfhconsumed;
String fname,lname;

public int getEmpid() {
	return empid;
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

public void setEmpid(int empid) {
	this.empid = empid;
}

public int getLeavesid() {
	return leavesid;
}

public void setLeavesid(int leavesid) {
	this.leavesid = leavesid;
}

public int getAnnualalloted() {
	return annualalloted;
}

public void setAnnualalloted(int annualalloted) {
	this.annualalloted = annualalloted;
}

public int getAnnualconsumed() {
	return annualconsumed;
}

public void setAnnualconsumed(int annualconsumed) {
	this.annualconsumed = annualconsumed;
}

public int getSickalloted() {
	return sickalloted;
}

public void setSickalloted(int sickalloted) {
	this.sickalloted = sickalloted;
}

public int getSickconsumed() {
	return sickconsumed;
}

public void setSickconsumed(int sickconsumed) {
	this.sickconsumed = sickconsumed;
}

public int getWfhalloted() {
	return wfhalloted;
}

public void setWfhalloted(int wfhalloted) {
	this.wfhalloted = wfhalloted;
}

public int getWfhconsumed() {
	return wfhconsumed;
}

public void setWfhconsumed(int wfhconsumed) {
	this.wfhconsumed = wfhconsumed;
}

}
