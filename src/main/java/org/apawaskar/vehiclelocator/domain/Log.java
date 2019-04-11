package org.apawaskar.vehiclelocator.domain;

import java.util.Date;

public class Log{

	private Location location;
	
	private Date timeStamp;
		
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
