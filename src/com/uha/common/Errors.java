package com.uha.common;

public enum Errors {
	DUPLICATE("Entry already exists."), 
	GENERAL("There was an unforseen error.");

	private String name;

	private Errors(String name) {
		this.name = name;
	}

	public String getLabel() {
		return name;
	}
}
