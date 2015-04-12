package entity;

import java.sql.Timestamp;

/**
 * StutFolw entity. @author MyEclipse Persistence Tools
 */

public class StutFolw implements java.io.Serializable {

	// Fields

	private Long id;
	private Tear tear;
	private Stut stut;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public StutFolw() {
	}

	/** full constructor */
	public StutFolw(Tear tear, Stut stut, Timestamp time) {
		this.tear = tear;
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

	public Tear getTear() {
		return this.tear;
	}

	public void setTear(Tear tear) {
		this.tear = tear;
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