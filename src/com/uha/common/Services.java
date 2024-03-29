package com.uha.common;


public enum Services {
	BLOOD("Blood Work"), 
	OPHTH("Ophthalmology"),
	CARDIO("Cardiology"), 
	DENTAL("Dental"),
	INTMED("Internal Medicine"), 
	ENT("ENT"),
	PEDIA("Pediatrics"), 
	GASTRO("Gastroenterology"), 
	GYNEO("Gyneocology"),
	UROLOGY("Urology"), 
	PSYCH("Psychiatry"),
	PODIA("Podiatry");
	
	
	private String name;
	private Services(String name) {
		this.name = name;
	}
	public String getLabel() {
		return name;
	}
	public static Services getValue(String label) {
	    if (label != null) {
	      for (Services b : Services.values()) {
	        if (label.equalsIgnoreCase(b.name)) {
	          return b;
	        }
	      }
	    }
	    return null;
	  }
}
