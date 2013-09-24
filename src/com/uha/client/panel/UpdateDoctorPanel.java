package com.uha.client.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.uha.client.widgets.IDTextField;
import com.uha.client.widgets.SubmitButton;
import com.uha.common.Controller;
import com.uha.common.Doctor;
import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public class UpdateDoctorPanel extends UHAPanel {

	private IDTextField idTextField;
	private JButton searchBtn;
	private JPanel showHidePanel;
	private SubmitButton updateBtn;
	private JButton btnCancel;
	private JPanel doctorStatusPanel;
	private JRadioButton rdbtnCheckedIn;
	private JRadioButton rdbtnCheckedOut;
	private Doctor doctor;

	public UpdateDoctorPanel(Controller controller) {
		super(controller);

		idTextField = new IDTextField();
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(idTextField.getText().equals("") || idTextField.getText()
						.equals(idTextField.getInitText()))) {
					getDoctor(idTextField.getText().trim());
				}

			}
		});

		showHidePanel = new JPanel();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(17)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																showHidePanel,
																GroupLayout.PREFERRED_SIZE,
																306,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				idTextField,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				searchBtn)))
										.addContainerGap(127, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								groupLayout
										.createSequentialGroup()
										.addGap(63)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(searchBtn)
														.addComponent(
																idTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(showHidePanel,
												GroupLayout.PREFERRED_SIZE,
												241, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(39, Short.MAX_VALUE)));
		doctorStatusPanel = new JPanel();

		showHidePanel.add(doctorStatusPanel);

		rdbtnCheckedIn = new JRadioButton("Checked In");
		rdbtnCheckedIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnCheckedIn.isSelected()) {
					rdbtnCheckedOut.setSelected(false);
				}
			}
		});
		doctorStatusPanel.add(rdbtnCheckedIn);

		rdbtnCheckedOut = new JRadioButton("Checked out");
		rdbtnCheckedOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnCheckedOut.isSelected()) {
					rdbtnCheckedIn.setSelected(false);
				}
			}
		});
		doctorStatusPanel.add(rdbtnCheckedOut);
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

	protected void getDoctor(String id) {
		clear();
		Doctor doctor = controller.getDoctor(id);
		this.doctor = doctor;
		if (doctor != null) {
			showHidePanel.setVisible(true);
			if (doctor.isCheckedIn()) {
				setAvailable(true);
			} else {
				setAvailable(false);
			}
		}
	}

	private void setAvailable(boolean b) {
		rdbtnCheckedIn.setSelected(b);
		rdbtnCheckedOut.setSelected(!b);
	}

	@Override
	protected void initPanel() {

	}

	public void clear() {
		rdbtnCheckedIn.setSelected(false);
		rdbtnCheckedOut.setSelected(false);
	}

	public void submit() {
		if (doctor.isCheckedIn() != rdbtnCheckedIn.isSelected()) {
			controller.updateDoctorCheckedIn(doctor.getId(),
					rdbtnCheckedIn.isSelected());
		}
		cancel();
	}

}
