package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ReseSort entity. @author MyEclipse Persistence Tools
 */

public class ReseSort implements java.io.Serializable {

	// Fields

	private Short id;
	private String name;
	private Set reses = new HashSet(0);

	// Constructors

	/** default constructor */
	public ReseSort() {
	}

	/** minimal constructor */
	public ReseSort(String name) {
		this.name = name;
	}

	/** full constructor */
	public ReseSort(String name, Set reses) {
		this.name = name;
		this.reses = reses;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getReses() {
		return this.reses;
	}

	public void setReses(Set reses) {
		this.reses = reses;
	}

}