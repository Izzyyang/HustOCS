package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Admn entity. @author MyEclipse Persistence Tools
 */

public class Admn implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String passwd;
	private String email;
	private Short status;
	private String idcard;
	private Timestamp time;
	private Set reses = new HashSet(0);
	private Set lesns = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admn() {
	}

	/** minimal constructor */
	public Admn(String id, String name, String passwd, String email,
			Short status, String idcard, Timestamp time) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.status = status;
		this.idcard = idcard;
		this.time = time;
	}

	/** full constructor */
	public Admn(String id, String name, String passwd, String email,
			Short status, String idcard, Timestamp time, Set reses, Set lesns) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.status = status;
		this.idcard = idcard;
		this.time = time;
		this.reses = reses;
		this.lesns = lesns;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	public Set getReses() {
		return this.reses;
	}

	public void setReses(Set reses) {
		this.reses = reses;
	}

	public Set getLesns() {
		return this.lesns;
	}

	public void setLesns(Set lesns) {
		this.lesns = lesns;
	}

}