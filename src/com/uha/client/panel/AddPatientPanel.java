package com.uha.client.panel;

import com.uha.common.Controller;
import com.uha.common.Patient;

@SuppressWarnings("serial")
public class AddPatientPanel extends AddUHAClientPanel {

	public AddPatientPanel(Controller controller) {
		super(controller);
	}

	@Override
	protected void initClient() {
		// TODO Auto-generated method stub

	}

	@Override
	public void submit() {
		client = new Patient(getID(), getName(), getServices());
		if (controller.insertPatient(client)) {
			clear();
		}

	}
	
	public void clear() {
		super.clear();
	}

}
