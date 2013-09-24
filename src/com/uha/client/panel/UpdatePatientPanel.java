package com.uha.client.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.uha.client.widgets.IDTextField;
import com.uha.client.widgets.ServicesPanel;
import com.uha.client.widgets.SubmitButton;
import com.uha.common.Controller;
import com.uha.common.Errors;
import com.uha.common.UHAClient;
import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public class UpdatePatientPanel extends UHAPanel {
	private ServicesPanel servicesPanel;
	private JButton searchBtn;
	private IDTextField idTextField;
	private SubmitButton updateBtn;
	private JPanel showHidePanel;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public UpdatePatientPanel(Controller controller) {
		super(controller);
		
		idTextField = new IDTextField();
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(idTextField.getText().equals("") || idTextField.getText().equals(idTextField.getInitText()))) {
					getPatient(idTextField.getText().trim());
				}
					
			}
		});
		
		showHidePanel = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(showHidePanel, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBtn)))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(searchBtn)
						.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(showHidePanel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		servicesPanel = new ServicesPanel();
		showHidePanel.add(servicesPanel);
		updateBtn = new SubmitButton(this, "Update");
		showHidePanel.add(updateBtn);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancel();
			}
		});
		showHidePanel.add(btnCancel);
		setLayout(groupLayout);
		
		showHidePanel.setVisible(false);
	}

	protected void cancel() {
		clear();
		idTextField.clear();
		showHidePanel.setVisible(false);
	}

	protected void getPatient(String id) {
		UHAClient patient = controller.getPatient(id);
		if (patient != null) {
			showHidePanel.setVisible(true);
			servicesPanel.disableServices(patient.getServices());
		}
		
	}

	@Override
	protected void initPanel() {
		// TODO Auto-generated method stub
		
	}
	
	public void submit() {
		System.out.println("Update");
	}
}
