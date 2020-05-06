package com.vcs.hibernate;

/**
 * Zone entity. @author MyEclipse Persistence Tools
 */

public class Zone implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int zoneId;
	private Floor floor;
	private String zoneName;
	private String zoneDesc;

	// Constructors

	/** default constructor */
	public Zone() {
	}

	/** minimal constructor */
	public Zone(int zoneId) {
		this.zoneId = zoneId;
	}

	/** full constructor */
	public Zone(int zoneId, Floor floor, String zoneName, String zoneDesc) {
		this.zoneId = zoneId;
		this.floor = floor;
		this.zoneName = zoneName;
		this.zoneDesc = zoneDesc;
	}

	// Property accessors

	public int getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public Floor getFloor() {
		return this.floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public String getZoneName() {
		return this.zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneDesc() {
		return this.zoneDesc;
	}

	public void setZoneDesc(String zoneDesc) {
		this.zoneDesc = zoneDesc;
	}

}