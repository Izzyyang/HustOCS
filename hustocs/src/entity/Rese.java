package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Rese entity. @author MyEclipse Persistence Tools
 */

public class Rese implements java.io.Serializable {

	// Fields

	private String id;
	private Lesn lesn;
	private ReseSort reseSort;
	private Admn admn;
	private String title;
	private Short status;
	private Timestamp time;
	private Set reseFilses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rese() {
	}

	/** minimal constructor */
	public Rese(String id, Lesn lesn, ReseSort reseSort, Admn admn,
			String title, Short status, Timestamp time) {
		this.id = id;
		this.lesn = lesn;
		this.reseSort = reseSort;
		this.admn = admn;
		this.title = title;
		this.status = status;
		this.time = time;
	}

	/** full constructor */
	public Rese(String id, Lesn lesn, ReseSort reseSort, Admn admn,
			String title, Short status, Timestamp time, Set reseFilses) {
		this.id = id;
		this.lesn = lesn;
		this.reseSort = reseSort;
		this.admn = admn;
		this.title = title;
		this.status = status;
		this.time = time;
		this.reseFilses = reseFilses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Lesn getLesn() {
		return this.lesn;
	}

	public void setLesn(Lesn lesn) {
		this.lesn = lesn;
	}

	public ReseSort getReseSort() {
		return this.reseSort;
	}

	public void setReseSort(ReseSort reseSort) {
		this.reseSort = reseSort;
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

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set getReseFilses() {
		return this.reseFilses;
	}

	public void setReseFilses(Set reseFilses) {
		this.reseFilses = reseFilses;
	}

}