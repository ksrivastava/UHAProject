package com.uha.client.widgets;

import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public class ClearButton extends UHAButton {

	public ClearButton(UHAPanel panel) {
		super("Clear", panel);
	}

	@Override
	protected void execute(UHAPanel panel) {
		panel.clear();

	}

}
