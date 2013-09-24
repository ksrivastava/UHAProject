package com.uha.client.widgets;

import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public class SubmitButton extends UHAButton {
	
	public SubmitButton(UHAPanel panel) {
		super("Submit", panel);
	}
	
	public SubmitButton(UHAPanel panel, String text) {
		super(text, panel);
	}

	protected void execute(UHAPanel panel) {
		panel.submit();
	}
}
