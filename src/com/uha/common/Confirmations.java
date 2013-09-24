package com.uha.common;

public enum Confirmations {
	
	SAVED("Entry saved."),
	UPDATED("Update Successful.");
	
	private String name;

	private Confirmations(String name) {
		this.name = name;
	}

	public String getLabel() {
		return name;
	}
}
