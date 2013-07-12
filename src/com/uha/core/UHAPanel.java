package com.uha.core;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.uha.common.Controller;

@SuppressWarnings("serial")
public abstract class UHAPanel extends JPanel {
	
	private Controller controller;

	public UHAPanel(Controller controller) {
		this.controller = controller;
		setLayout(new BorderLayout(0, 0));
		initPanel();
	}

	protected abstract void initPanel();
	
}
