package com.uha.client.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.uha.client.widgets.ClearButton;
import com.uha.client.widgets.IDTextField;
import com.uha.client.widgets.NameTextField;
import com.uha.client.widgets.ServicesPanel;
import com.uha.client.widgets.SubmitButton;
import com.uha.client.widgets.UHAButton;
import com.uha.client.widgets.UHATextField;
import com.uha.common.Controller;
import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public class AddPatientPanel extends UHAPanel {

	private UHATextField idTextField;
	private UHATextField nameTextField;
	private UHAButton clrButton;
	private UHATextField familyIdTextField;
	private UHAButton submitButton;
	private ServicesPanel servicesPanel;
	private final static String doubleSpace = "  ";

	public AddPatientPanel(Controller controller) {
		super(controller);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 484, 0 };
		gridBagLayout.rowHeights = new int[] { 100, 220, 100, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel regPanel = new JPanel();
		GridBagConstraints gbc_regPanel = new GridBagConstraints();
		gbc_regPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_regPanel.insets = new Insets(0, 0, 5, 0);
		gbc_regPanel.gridx = 0;
		gbc_regPanel.gridy = 0;
		add(regPanel, gbc_regPanel);

		idTextField = new IDTextField();
		regPanel.add(idTextField);

		nameTextField = new NameTextField();
		regPanel.add(nameTextField);

		clrButton = new ClearButton(this);
		regPanel.add(clrButton);

		JPanel servPanel = new JPanel();
		GridBagConstraints gbc_servPanel = new GridBagConstraints();
		gbc_servPanel.insets = new Insets(0, 0, 5, 0);
		gbc_servPanel.gridx = 0;
		gbc_servPanel.gridy = 1;
		add(servPanel, gbc_servPanel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		servPanel.setLayout(gbl_panel);

		JLabel lblChooseServices = new JLabel(doubleSpace + "Choose services:");
		lblChooseServices.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblChooseServices = new GridBagConstraints();
		gbc_lblChooseServices.anchor = GridBagConstraints.WEST;
		gbc_lblChooseServices.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseServices.gridx = 0;
		gbc_lblChooseServices.gridy = 0;
		servPanel.add(lblChooseServices, gbc_lblChooseServices);

		servicesPanel = new ServicesPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		servPanel.add(servicesPanel, gbc_panel_1);

		submitButton = new SubmitButton(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		add(submitButton, gbc_btnNewButton);

	}

	@Override
	protected void initPanel() {
		// TODO Auto-generated method stub

	}

	public void submit() {
		System.out.println("Submit");
	}

	public void clear() {
		System.out.println("Clear");
	}

}
