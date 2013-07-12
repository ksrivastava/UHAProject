package com.uha.client.panel;

import javax.swing.JCheckBox;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.uha.common.Controller;
import com.uha.core.UHAPanel;

@SuppressWarnings("serial")
public class AddPatientPanel extends UHAPanel {
	
	public AddPatientPanel(Controller controller) {
		super(controller);
		
	
	}

	@Override
	protected void initPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("6dlu"),
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("4dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Blood Work");
		add(chckbxNewCheckBox, "2, 2");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ophthalmology");
		add(chckbxNewCheckBox_1, "4, 2");
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Cardiology");
		add(chckbxNewCheckBox_2, "2, 4");
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Dental");
		add(chckbxNewCheckBox_3, "4, 4");
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Internal Medicine");
		add(chckbxNewCheckBox_4, "2, 6");
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("ENT");
		add(chckbxNewCheckBox_5, "4, 6");
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Pediatrics");
		add(chckbxNewCheckBox_8, "2, 8");
		
		JCheckBox checkBox = new JCheckBox("Gastroenterology");
		add(checkBox, "4, 8");
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("Gyneocology");
		add(chckbxNewCheckBox_9, "2, 10");
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Urology");
		add(chckbxNewCheckBox_10, "4, 10");
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Psychiatry");
		add(chckbxNewCheckBox_6, "2, 12");
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Podiatry");
		add(chckbxNewCheckBox_7, "4, 12");
	}
}
