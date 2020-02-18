package org.apawaskar.vehiclelocator.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Logfeed {

	@JsonProperty("route_id")
	private String routeId;
	
	@JsonProperty("lat")
	private double latitute;
	
	@JsonProperty("long")
	private double longitude;
	
	@JsonProperty("vehicle_id")
	private long vehiceId;
	
	@JsonProperty("driver_id")
	private long driverId;
	
	@JsonProperty("timestamp")
	private Date timeStamp;
	
	@JsonProperty("lastStop")
	private boolean lastStop;

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public double getLatitute() {
		return latitute;
	}

	public void setLatitute(double latitute) {
		this.latitute = latitute;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public long getVehiceId() {
		return vehiceId;
	}

	public void setVehiceId(long vehiceId) {
		this.vehiceId = vehiceId;
	}

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Logfeed [routeId=" + routeId + ", latitute=" + latitute + ", longitude=" + longitude + ", vehiceId="
				+ vehiceId + ", driverId=" + driverId + ", timeStamp=" + timeStamp + "]";
	}

	public boolean isLastStop() {
		return lastStop;
	}

	public void setLastStop(boolean lastStop) {
		this.lastStop = lastStop;
	}
}
