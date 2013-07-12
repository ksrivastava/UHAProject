package com.uha.client.widgets;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public abstract class UHATextField extends JTextField {
	protected String text;
	protected String hint;

	public UHATextField() {
		initText();
		initHint();
		setColumns(15);
		setFocusTraversalPolicyProvider(false);
		setText(text);
		setToolTipText(hint);
		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (getText().equals("")) setText(text);

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (getText().equals(text)) setText("");

			}
		});
	}

	protected abstract void initHint();

	protected abstract void initText();
}
