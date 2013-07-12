package com.uha.client.widgets;


@SuppressWarnings("serial")
public class NameTextField extends UHATextField {

	@Override
	protected void initHint() {
		hint = "Enter full name of patient/doctor.";
		
	}

	@Override
	protected void initText() {
		text = "Enter name ...";
		
	}
}
