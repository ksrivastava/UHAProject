package com.uha.client.widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public abstract class UHAButton extends JButton {
	
	public UHAButton(String text, final UHAPanel panel) {
		setText(text);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				execute(panel);
			}
		});
	}

	protected abstract void execute(UHAPanel panel);
}
