package entity;

import java.sql.Timestamp;

/**
 * ReseFils entity. @author MyEclipse Persistence Tools
 */

public class ReseFils implements java.io.Serializable {

	// Fields

	private Long id;
	private Rese rese;
	private String uri;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public ReseFils() {
	}

	/** full constructor */
	public ReseFils(Rese rese, String uri, Timestamp time) {
		this.rese = rese;
		this.uri = uri;
		this.time = time;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rese getRese() {
		return this.rese;
	}

	public void setRese(Rese rese) {
		this.rese = rese;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}