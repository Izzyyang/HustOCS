package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Tear entity. @author MyEclipse Persistence Tools
 */

public class Tear implements java.io.Serializable {
	// Fields
	private String id;  //id
	private String email;  //邮箱
	private String passwd;  //密码
	private String pic;  //头像
	private Timestamp time;  //注册时间
	private Short status;   
	private Set tearInfos = new HashSet(0);
	private Set stutFolws = new HashSet(0);
	private Set lesns = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tear() {
	}

	/** minimal constructor */
	public Tear(String id, String email, String passwd, Timestamp time,
			Short status) {
		this.id = id;
		this.email = email;
		this.passwd = passwd;
		this.time = time;
		this.status = status;
	}

	/** full constructor */
	public Tear(String id, String email, String passwd, String pic,Timestamp time,
			Short status, Set tearInfos, Set stutFolws, Set lesns) {
		this.id = id;
		this.email = email;
		this.passwd = passwd;
		this.time = time;
		this.status = status;
		this.tearInfos = tearInfos;
		this.stutFolws = stutFolws;
		this.lesns = lesns;
		this.pic = pic;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Set getTearInfos() {
		return this.tearInfos;
	}

	public void setTearInfos(Set tearInfos) {
		this.tearInfos = tearInfos;
	}

	public Set getStutFolws() {
		return this.stutFolws;
	}

	public void setStutFolws(Set stutFolws) {
		this.stutFolws = stutFolws;
	}

	public Set getLesns() {
		return this.lesns;
	}

	public void setLesns(Set lesns) {
		this.lesns = lesns;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}