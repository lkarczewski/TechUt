package com.example.jdbcdemo.domain;

public class Club {

	private long id;
	private String name;
	private String dateOfFoundation;
	private boolean isChampion;
	private double assets;

	public Club() {
	}

	public Club(String name, String dateOfFoundation, boolean isChampion, double assets) {
		super();
		this.name = name;
		this.dateOfFoundation = dateOfFoundation;
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

	public String getDateOfFoundation() {
		return dateOfFoundation;
	}

	public void setDateOfFoundation(String dateOfFoundation) {
		this.dateOfFoundation = dateOfFoundation;
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
}
