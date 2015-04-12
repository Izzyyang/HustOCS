package entity;

import java.sql.Timestamp;

/**
 * TearInfo entity. @author MyEclipse Persistence Tools
 */

public class TearInfo implements java.io.Serializable {

	// Fields

	private String id;
	private Tear tear;
	private Acay acay;
	private String name;
	private String phone;
	private String brief;
	private String idcard;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public TearInfo() {
	}

	/** minimal constructor */
	public TearInfo(String id, Tear tear, Acay acay, String name, String brief,
			String idcard, Timestamp time) {
		this.id = id;
		this.tear = tear;
		this.acay = acay;
		this.name = name;
		this.brief = brief;
		this.idcard = idcard;
		this.time = time;
	}

	/** full constructor */
	public TearInfo(String id, Tear tear, Acay acay, String name, String phone,
			String brief, String idcard, Timestamp time) {
		this.id = id;
		this.tear = tear;
		this.acay = acay;
		this.name = name;
		this.phone = phone;
		this.brief = brief;
		this.idcard = idcard;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Tear getTear() {
		return this.tear;
	}

	public void setTear(Tear tear) {
		this.tear = tear;
	}

	public Acay getAcay() {
		return this.acay;
	}

	public void setAcay(Acay acay) {
		this.acay = acay;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}