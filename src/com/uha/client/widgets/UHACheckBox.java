package com.uha.client.widgets;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class UHACheckBox extends JCheckBox {

	public UHACheckBox(String label) {
		super(label);
	}

	public void makeExclusive(final ServicesPanel panel) {
		addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (isSelected()) {
					panel.deselectAllExcept(UHACheckBox.this);
				}
			}
		});
	}

}
