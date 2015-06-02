package entity;

import java.sql.Timestamp;

/**
 * Resource entity. @author MyEclipse Persistence Tools
 */

public class Resource implements java.io.Serializable {

	// Fields
	private String id;
	private String lessonId;
	private short resourceSortId;
	private String adminId;
	private String title;
	private Short status;
	private Timestamp time;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLessonId() {
		return lessonId;
	}

	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}

	public short getResourceSortId() {
		return resourceSortId;
	}

	public void setResourceSortId(short resourceSortId) {
		this.resourceSortId = resourceSortId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** full constructor */
	public Resource(String id, String lessonId, short resourceSortId, String adminId,
			String title, Short status, Timestamp time) {
		this.id = id;
		this.lessonId = lessonId;
		this.resourceSortId = resourceSortId;
		this.adminId = adminId;
		this.title = title;
		this.status = status;
		this.time = time;
	}
}