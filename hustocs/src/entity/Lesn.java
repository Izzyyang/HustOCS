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
	private String fclassify; //一级分类；
	private String sclassify; //课程二级分类
	private Tear tear;  //授课老师
	private Acay acay;  //
	private Admn admn;  //管理员
	private String title;
	private String brief;
	private Timestamp time;
	private Short status;
	private String picaddress; //课程图片地址；
	private Set stutHisies = new HashSet(0);  //浏览历史记录
	private Set reses = new HashSet(0);   //课程资源
	private Set stutColts = new HashSet(0);  //收藏学生集合
    
	// Constructors

	/** default constructor */
	public Lesn() {
	}

	/** minimal constructor */
	public Lesn(String id,String fclassify,String sclassify, Tear tear, Admn admn, String title, String brief,
			Timestamp time, Short status) {
		this.id = id;
		this.fclassify = fclassify;
		this.sclassify = sclassify;
		this.tear = tear;
		this.admn = admn;
		this.title = title;
		this.brief = brief;
		this.time = time;
		this.status = status;
	}

	/** full constructor */
	public Lesn(String id,String fclassify,String sclassify,Tear tear, Acay acay, Admn admn, String title,
			String brief,String picaddress,Timestamp time, Short status, Set stutHisies,
			Set reses, Set stutColts) {
		this.id = id;
		this.fclassify = fclassify;
		this.sclassify = sclassify;
		this.tear = tear;
		this.acay = acay;
		this.admn = admn;
		this.title = title;
		this.brief = brief;
		this.time = time;
		this.picaddress = picaddress;
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

	public String getPicaddress() {
		return picaddress;
	}

	public void setPicaddress(String picaddress) {
		this.picaddress = picaddress;
	}

	public String getFclassify() {
		return fclassify;
	}

	public void setFclassify(String fclassify) {
		this.fclassify = fclassify;
	}

	public String getSclassify() {
		return sclassify;
	}

	public void setSclassify(String sclassify) {
		this.sclassify = sclassify;
	}
	
}