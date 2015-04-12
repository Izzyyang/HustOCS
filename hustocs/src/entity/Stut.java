package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Stut entity. @author MyEclipse Persistence Tools
 */

public class Stut implements java.io.Serializable {

	// Fields

	private String id;
	private String passwd;
	private Timestamp time;
	private String email;
	private Short status;
	private Set stutHisies = new HashSet(0);
	private StutInfo stutInfo;
	private Set stutColts = new HashSet(0);
	private Set stutFolws = new HashSet(0);

	// Constructors

	/** default constructor */
	public Stut() {
	}

	/** minimal constructor */
	public Stut(String id, String passwd, Timestamp time, String email,
			Short status) {
		this.id = id;
		this.passwd = passwd;
		this.time = time;
		this.email = email;
		this.status = status;
	}

	/** full constructor */
	public Stut(String id, String passwd, Timestamp time, String email,
			Short status, Set stutHisies, StutInfo stutInfo, Set stutColts,
			Set stutFolws) {
		this.id = id;
		this.passwd = passwd;
		this.time = time;
		this.email = email;
		this.status = status;
		this.stutHisies = stutHisies;
		this.stutInfo = stutInfo;
		this.stutColts = stutColts;
		this.stutFolws = stutFolws;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public StutInfo getStutInfo() {
		return this.stutInfo;
	}

	public void setStutInfo(StutInfo stutInfo) {
		this.stutInfo = stutInfo;
	}

	public Set getStutColts() {
		return this.stutColts;
	}

	public void setStutColts(Set stutColts) {
		this.stutColts = stutColts;
	}

	public Set getStutFolws() {
		return this.stutFolws;
	}

	public void setStutFolws(Set stutFolws) {
		this.stutFolws = stutFolws;
	}

}