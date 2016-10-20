package com.mindtree.entity;

import javax.persistence.*;


@Entity
@Table(name="Candidates")
public class Candidates {
	@Id @GeneratedValue
	@Column(name="Id")
	private int id;
	@Column(name="name")
	private String name;
	
	@Column(name="party")
	private String party;	
	
	public Candidates() {
		super();	
	}	
	
	public Candidates( String name, String party) {
		
		this.name = name;
		
		this.party = party;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}	
}
