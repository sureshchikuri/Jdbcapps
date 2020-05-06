package com.vcs.hibernate;


/**
 * Floor entity. @author MyEclipse Persistence Tools
 */

public class Floor implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	// Fields

	private int floorId;
	private String floorName;
	private String floorDesc;

	// Constructors

	/** default constructor */
	public Floor() {
	}

	/** minimal constructor */
	public Floor(int floorId) {
		this.floorId = floorId;
	}

	/** full constructor */
	public Floor(int floorId, String floorName, String floorDesc) {
		this.floorId = floorId;
		this.floorName = floorName;
		this.floorDesc = floorDesc;
	}

	// Property accessors

	public int getFloorId() {
		return this.floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return this.floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getFloorDesc() {
		return this.floorDesc;
	}

	public void setFloorDesc(String floorDesc) {
		this.floorDesc = floorDesc;
	}

}