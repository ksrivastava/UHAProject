package com.uha.common;



public class Doctor extends UHAClient {
	
	private boolean checkedIn;
	private Services primaryService;
	
	public Doctor() {
		
	}
	
	public Doctor(String id, String name, Services primaryService) {
		super(id, name);
		this.primaryService = primaryService;
		checkedIn = true;
	}

	public Services getPrimaryService() {
		return primaryService;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public void setPrimaryService(Services primaryService) {
		this.primaryService = primaryService;
	}
	
}