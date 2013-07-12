package com.uha.common;

import com.uha.server.Model;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public void selectAll() {
		model.selectAll();
		
	}

}
