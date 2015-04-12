package entity;

import java.sql.Timestamp;

/**
 * StutColt entity. @author MyEclipse Persistence Tools
 */

public class StutColt implements java.io.Serializable {

	// Fields

	private Long id;
	private Lesn lesn;
	private Stut stut;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public StutColt() {
	}

	/** full constructor */
	public StutColt(Lesn lesn, Stut stut, Timestamp time) {
		this.lesn = lesn;
		this.stut = stut;
		this.time = time;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lesn getLesn() {
		return this.lesn;
	}

	public void setLesn(Lesn lesn) {
		this.lesn = lesn;
	}

	public Stut getStut() {
		return this.stut;
	}

	public void setStut(Stut stut) {
		this.stut = stut;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}