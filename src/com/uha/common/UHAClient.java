package com.uha.common;

import java.util.ArrayList;
import java.util.List;

import com.uha.core.Pair;

public abstract class UHAClient {
	private String id;
	private String name;
	private List<Pair<Services, Boolean>> services;
	private boolean available;
	
	public UHAClient() {
		services = new ArrayList<Pair<Services, Boolean>>();
	}
	
	public UHAClient(String id, String name, List<Pair<Services, Boolean>> services)  {
		this.id = id;
		this.name = name;
		this.services = services;
		this.available = true;
	}
	
	public UHAClient(String id, String name)  {
		this.id = id;
		this.name = name;
		this.available = true;
	}
	
	public void addService(Services service, boolean complete) {
		services.add(new Pair<Services, Boolean>(service, new Boolean(complete)));
	}
	
	public void removieService(Services service) {
		// services.remove(service);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<Pair<Services, Boolean>> getServices() {
		return services;
	}

	public void setServices(List<Pair<Services, Boolean>> services) {
		this.services = services;
	}
	
}
