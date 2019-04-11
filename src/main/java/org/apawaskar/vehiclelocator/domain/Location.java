package org.apawaskar.vehiclelocator.domain;

public class Location {

	private double latitute;
	
	private double longitude;

	private String description;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Location [latitute=" + latitute + ", longitude=" + longitude + ", description=" + description + "]";
	}
	
}
