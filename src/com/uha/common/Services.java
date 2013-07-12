package com.uha.common;

public enum Services {
	// TODO Finish Services Enum
	BLOOD("Blood Work");
	
	
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
