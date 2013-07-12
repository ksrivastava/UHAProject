package com.uha.client.widgets;


@SuppressWarnings("serial")
public class IDTextField extends UHATextField {

	@Override
	protected void initHint() {
		hint = "Enter ID of patient/doctor.";
		
	}

	@Override
	protected void initText() {
		text = "Enter ID ...";
	}

}
