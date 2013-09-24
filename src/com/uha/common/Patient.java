package com.uha.common;

import java.util.List;

import com.uha.core.Pair;


public class Patient extends UHAClient {
	
	public Patient(String id, String name, List<Pair<Services, Boolean>> services) {
		super(id, name, services);
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}


}
