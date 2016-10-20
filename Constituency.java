package com.mindtree.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Constituency")
public class Constituency {
	@Id @GeneratedValue
	@Column(name="Id")
	private int constituencyId;
	@Column(name="constituency_name")
	private String constituencyName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONSTITUENCY_CANDIDATES", joinColumns = { @JoinColumn(name = "constituencyId") }, inverseJoinColumns = { @JoinColumn(name = "id") })
	private Set<Candidates> contituencyCandidates = new HashSet<Candidates>();

	public Set<Candidates> getContituencyCandidates() {
		return contituencyCandidates;
	}
	public void setContituencyCandidates(Set<Candidates> contituencyCandidates) {
		this.contituencyCandidates = contituencyCandidates;
	}
	public Constituency(){}

	public int getConstituencyId() {
		return constituencyId;
	}
	public Constituency( String constituencyName, Set<Candidates> contituencyCandidates) {
		super();	
		this.constituencyName = constituencyName;
		this.contituencyCandidates = contituencyCandidates;
	}
	public void setConstituencyId(int id) {
		this.constituencyId = id;
	}
	public String getConstituencyName() {
		return constituencyName;
	}
	public void setConstituencyName(String name) {
		this.constituencyName = name;
	}

}
