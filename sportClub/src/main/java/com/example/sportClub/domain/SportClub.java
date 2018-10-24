package com.example.sportClub.domain;

import java.sql.Date;

public class SportClub {

	private long id;
	private String name;
	private Date dof;
	private boolean isChampion;
	private double assets;
	
	public SportClub() {}

	public SportClub(long id, String name, Date dof, boolean isChampion, double assets) {
		super();
		this.id = id;
		this.name = name;
		this.dof = dof;
		this.isChampion = isChampion;
		this.assets = assets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDof() {
		return dof;
	}

	public void setDof(Date dof) {
		this.dof = dof;
	}

	public boolean isChampion() {
		return isChampion;
	}

	public void setChampion(boolean isChampion) {
		this.isChampion = isChampion;
	}

	public double getAssets() {
		return assets;
	}

	public void setAssets(double assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "SportClub [id=" + id + ", name=" + name + ", dof=" + dof + ", isChampion=" + isChampion + ", assets="
				+ assets + "]";
	}
}
