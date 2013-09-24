package com.uha.client.panel;

import com.uha.common.Controller;
import com.uha.common.Doctor;

@SuppressWarnings("serial")
public class AddDoctorPanel extends AddUHAClientPanel {

	public AddDoctorPanel(Controller controller) {
		super(controller);
		servicesPanel.makeExclusive();
		
	}

	@Override
	protected void initClient() {
		// TODO Auto-generated method stub

	}

	@Override
	public void submit() {
		client = new Doctor(getID(), getName(), getServices().get(0).getFirst());
		if (controller.insertDoctor(client)) {
			clear();
		}

	}
	
	public void clear() {
		super.clear();
	}

}
