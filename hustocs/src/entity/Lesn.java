package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Lesn entity. @author MyEclipse Persistence Tools
 */

public class Lesn implements java.io.Serializable {

	// Fields

	private String id;
	private Tear tear;
	private Acay acay;
	private Admn admn;
	private String title;
	private String brief;
	private Timestamp time;
	private Short status;
	private Set stutHisies = new HashSet(0);
	private Set reses = new HashSet(0);
	private Set stutColts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Lesn() {
	}

	/** minimal constructor */
	public Lesn(String id, Tear tear, Admn admn, String title, String brief,
			Timestamp time, Short status) {
		this.id = id;
		this.tear = tear;
		this.admn = admn;
		this.title = title;
		this.brief = brief;
		this.time = time;
		this.status = status;
	}

	/** full constructor */
	public Lesn(String id, Tear tear, Acay acay, Admn admn, String title,
			String brief, Timestamp time, Short status, Set stutHisies,
			Set reses, Set stutColts) {
		this.id = id;
		this.tear = tear;
		this.acay = acay;
		this.admn = admn;
		this.title = title;
		this.brief = brief;
		this.time = time;
		this.status = status;
		this.stutHisies = stutHisies;
		this.reses = reses;
		this.stutColts = stutColts;
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

	public Admn getAdmn() {
		return this.admn;
	}

	public void setAdmn(Admn admn) {
		this.admn = admn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Set getStutHisies() {
		return this.stutHisies;
	}

	public void setStutHisies(Set stutHisies) {
		this.stutHisies = stutHisies;
	}

	public Set getReses() {
		return this.reses;
	}

	public void setReses(Set reses) {
		this.reses = reses;
	}

	public Set getStutColts() {
		return this.stutColts;
	}

	public void setStutColts(Set stutColts) {
		this.stutColts = stutColts;
	}

}