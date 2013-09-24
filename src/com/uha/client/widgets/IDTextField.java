package com.uha.client.widgets;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class IDTextField extends UHATextField {

	public IDTextField() {
		setFocusTraversalKeysEnabled(false);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				setText(getText().toUpperCase());
			}
		});
	}

	@Override
	protected void initHint() {
		hint = "Enter ID of patient/doctor.";

	}

	@Override
	protected void initText() {
		text = "Enter ID ...";
	}

}
