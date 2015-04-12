package entity;

import java.sql.Timestamp;

/**
 * StutInfo entity. @author MyEclipse Persistence Tools
 */

public class StutInfo implements java.io.Serializable {

	// Fields

	private String id;
	private Acay acay;
	private Stut stut;
	private String name;
	private String avartar;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public StutInfo() {
	}

	/** minimal constructor */
	public StutInfo(String id, Acay acay, String name, String avartar,
			Timestamp time) {
		this.id = id;
		this.acay = acay;
		this.name = name;
		this.avartar = avartar;
		this.time = time;
	}

	/** full constructor */
	public StutInfo(String id, Acay acay, Stut stut, String name,
			String avartar, Timestamp time) {
		this.id = id;
		this.acay = acay;
		this.stut = stut;
		this.name = name;
		this.avartar = avartar;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Acay getAcay() {
		return this.acay;
	}

	public void setAcay(Acay acay) {
		this.acay = acay;
	}

	public Stut getStut() {
		return this.stut;
	}

	public void setStut(Stut stut) {
		this.stut = stut;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvartar() {
		return this.avartar;
	}

	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}