package com.example.jdbcdemo.domain;

public class Club {

	private String name;
	private String dateOfFoundation;
	private boolean isChampion;
	private double assets;

	public Club(String name, String dateOfFoundation, boolean isChampion, double assets) {
		this.name = name;
		this.dateOfFoundation = dateOfFoundation;
		this.isChampion = isChampion;
		this.assets = assets;
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

	@Override
	public String toString() {
		return "Club{" +
				"name='" + name + '\'' +
				", dateOfFoundation='" + dateOfFoundation + '\'' +
				", isChampion=" + isChampion +
				", assets=" + assets +
				'}';
	}
}
