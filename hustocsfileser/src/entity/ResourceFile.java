package entity;

import java.sql.Timestamp;

public class ResourceFile {

	private Long id;
	private String resourceId;
	private String uri;
	private Timestamp time;
	
	public ResourceFile(){}
	public ResourceFile(Long id, String resourceId, String uri, Timestamp time) {
		this.id = id;
		this.resourceId = resourceId;
		this.uri = uri;
		this.time = time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
