package com.uha.client;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.uha.client.panel.AddDoctorPanel;
import com.uha.client.panel.AddPatientPanel;
import com.uha.client.panel.UpdateDoctorPanel;
import com.uha.client.panel.UpdatePatientPanel;
import com.uha.common.Controller;
import com.uha.core.UHAPanel;

public class MainScreen extends JFrame {
	
	private final static int START_X = 100;
	private final static int START_Y = 100;
	private final static int WIDTH = 600;
	private final static int HEIGHT = 500;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private UHAPanel addPatientPanel;
	private UHAPanel addDoctorPanel;
	private UHAPanel updatePatientPanel;
	private Component updateDoctorPanel;
	
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
		
		JPanel addPatientTabPanel = new JPanel();
		tabPanel.addTab("Add Patient", null, addPatientTabPanel, null);
		
		addPatientPanel = new AddPatientPanel(controller);
		addPatientTabPanel.add(addPatientPanel);
		
		JPanel addDoctorTabPanel = new JPanel();
		tabPanel.addTab("Add Doctor", null, addDoctorTabPanel, null);
		tabPanel.setEnabledAt(2, true);
		
		addDoctorPanel = new AddDoctorPanel(controller);
		addDoctorTabPanel.add(addDoctorPanel);
		
		JPanel updatePatientTabPanel = new JPanel();
		tabPanel.addTab("Update Patient", null, updatePatientTabPanel, null);
		tabPanel.setEnabledAt(3, true);
		
		updatePatientPanel = new UpdatePatientPanel(controller);
		updatePatientTabPanel.add(updatePatientPanel);
		
		JPanel updateDoctorTabPanel = new JPanel();
		tabPanel.addTab("Update Doctor", null, updateDoctorTabPanel, null);
		tabPanel.setEnabledAt(4, true);
		
		updateDoctorPanel = new UpdateDoctorPanel(controller);
		updateDoctorTabPanel.add(updateDoctorPanel);
	}
}
