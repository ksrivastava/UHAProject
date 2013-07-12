package com.uha.client.widgets;

import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public class SubmitButton extends UHAButton {
	
	public SubmitButton(UHAPanel panel) {
		super("Submit", panel);
	}

	protected void execute(UHAPanel panel) {
		panel.submit();
	}
}
