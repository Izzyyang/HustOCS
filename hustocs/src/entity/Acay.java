package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Acay entity. @author MyEclipse Persistence Tools
 */

public class Acay implements java.io.Serializable {

	// Fields

	private Short id;
	private String name;
	private Set lesns = new HashSet(0);
	private Set stutInfos = new HashSet(0);
	private Set tearInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Acay() {
	}

	/** minimal constructor */
	public Acay(String name) {
		this.name = name;
	}

	/** full constructor */
	public Acay(String name, Set lesns, Set stutInfos, Set tearInfos) {
		this.name = name;
		this.lesns = lesns;
		this.stutInfos = stutInfos;
		this.tearInfos = tearInfos;
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

	public Set getLesns() {
		return this.lesns;
	}

	public void setLesns(Set lesns) {
		this.lesns = lesns;
	}

	public Set getStutInfos() {
		return this.stutInfos;
	}

	public void setStutInfos(Set stutInfos) {
		this.stutInfos = stutInfos;
	}

	public Set getTearInfos() {
		return this.tearInfos;
	}

	public void setTearInfos(Set tearInfos) {
		this.tearInfos = tearInfos;
	}

}