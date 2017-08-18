package locationbean.copy;

public class LocationBean {
String location,locationAddress;
int locationid;

public int getLocationid() {
	return locationid;
}

public void setLocationid(int locationid) {
	this.locationid = locationid;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getLocationAddress() {
	return locationAddress;
}

public void setLocationAddress(String locationAddress) {
	this.locationAddress = locationAddress;
}
public String toString() {
    return "lob [locationid=" + locationid + ", locationname=" + location
            + ", locationaddress=" + locationAddress + "]";
}  

}
