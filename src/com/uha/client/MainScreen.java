package com.uha.client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.uha.common.Controller;
import java.awt.BorderLayout;

public class MainScreen extends JFrame {
	
	private final static int START_X = 100;
	private final static int START_Y = 100;
	private final static int WIDTH = 1000;
	private final static int HEIGHT = 500;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	
	private static final int IdTextBoxWidth = 180;
	
	public MainScreen(Controller controller) {
		this.controller = controller;
		initPanel();
	}

	private void initPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(START_X, START_Y, WIDTH, HEIGHT);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabPanel = new JTabbedPane();
		//tabPanel.setBounds(442, 5, 116, 98);
		contentPane.add(tabPanel);
		
		JPanel homePanel = new JPanel();
		tabPanel.addTab("Home", null, homePanel, null);
		tabPanel.setEnabledAt(0, true);
		
		JPanel addPatientPanel = new JPanel();
		tabPanel.addTab("Add Patient", null, addPatientPanel, null);
		tabPanel.setEnabledAt(1, true);
		
		JPanel addDoctorPanel = new JPanel();
		tabPanel.addTab("Add Doctor", null, addDoctorPanel, null);
		tabPanel.setEnabledAt(2, true);
	}
}
